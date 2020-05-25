package com.nl2go.hetzner.dns;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.nl2go.hetzner.dns.model.Record;
import com.nl2go.hetzner.dns.model.RecordInput;
import com.nl2go.hetzner.dns.model.Zone;
import com.nl2go.hetzner.dns.model.ZoneInput;
import com.nl2go.hetzner.dns.service.HetznerDnsApiService;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.text.MessageFormat.format;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HetznerDnsApiRecordsTest {

    private static final String RECORDID = "random124";

    private static final String ZONEID = "AhywbURnqpPifOAZww91";

    @Value("${hetzner-dns-api.token}")
    private String authApiToken;

    @Autowired
    private HetznerDnsApiService hetznerDNSApiService;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(9999);

    @Before
    public void resetWiremock() {
        wireMockRule.resetAll();
    }

    @Test
    public void getRecordsReturnsEmptyList() {

        stubFor(get(urlEqualTo("/records"))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("records_empty.json")));

        List<Record> records = hetznerDNSApiService.listRecords().getRecords();

        assertEquals(0, records.size());
    }

    @Test
    public void getRecordsReturnsListGreaterThanZero() {

        stubFor(get(urlEqualTo("/records"))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("records.json")));

        List<Record> records = hetznerDNSApiService.listRecords().getRecords();

        assertEquals(4, records.size());
    }

    @Test
    public void getRecordWithIdReturnsRecordWhenRecordExist() {

        stubFor(get(urlEqualTo(format("/records/{0}", RECORDID)))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("record.json")));

        Record record = hetznerDNSApiService.getRecord(RECORDID);

        assertNotNull(record);

        assertEquals(RECORDID, record.getId());
        assertEquals(ZONEID, record.getZoneId());
        assertEquals("subdomain-test", record.getName());
        assertEquals("127.0.0.222", record.getValue());
    }

    @Test
    public void getRecordWithIdReturns404WhenRecordDoesNotExist() {

        String notExistingRecordId = "DoesNotExist";

        stubFor(get(urlEqualTo(format("/records/{0}", notExistingRecordId)))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .willReturn(aResponse().withStatus(HttpStatus.NOT_FOUND.value())));

        Record record = hetznerDNSApiService.getRecord(notExistingRecordId);

        assertNull(record);
    }

    @Test
    public void createRecordWithValidInputCreatesRecord() {
        stubFor(post(urlEqualTo("/records"))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .withRequestBody(equalToJson("{\"zone_id\":\"" + ZONEID + "\",\"type\":\"A\",\"name\":\"subdomain-test\",\"value\":\"127.0.0.222\",\"ttl\":0}"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("record.json")));

        RecordInput recordInput = getRecordInput();

        Record record = hetznerDNSApiService.createRecord(recordInput);

        assertEquals(RECORDID, record.getId());
        assertEquals("subdomain-test", record.getName());
        assertEquals("127.0.0.222", record.getValue());
        assertEquals(ZONEID, record.getZoneId());
        assertEquals("A", record.getType());
    }

    @Test
    public void updateRecordWithValidInputUpdatesRecord() {
        stubFor(put(urlEqualTo(format("/records/{0}", RECORDID)))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .withRequestBody(equalToJson("{\"zone_id\":\"" + ZONEID + "\",\"type\":\"A\",\"name\":\"subdomain-test\",\"value\":\"127.0.0.222\",\"ttl\":0}"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("record.json")));

        RecordInput recordInput = getRecordInput();

        Record record = hetznerDNSApiService.updateRecord(recordInput, RECORDID);

        assertEquals(RECORDID, record.getId());
        assertEquals("subdomain-test", record.getName());
        assertEquals("127.0.0.222", record.getValue());
        assertEquals(ZONEID, record.getZoneId());
        assertEquals("A", record.getType());
    }

    @Test
    public void deleteRecordWithValidIdDeletesRecord() {
        stubFor(delete(urlEqualTo(format("/records/{0}", RECORDID)))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .willReturn(aResponse().withStatus(HttpStatus.OK.value())));

        hetznerDNSApiService.deleteRecord(RECORDID);
    }

    private RecordInput getRecordInput() {
        RecordInput recordInput = new RecordInput();
        recordInput.setName("subdomain-test");
        recordInput.setValue("127.0.0.222");
        recordInput.setZoneId(ZONEID);
        recordInput.setType("A");
        return recordInput;
    }
}
