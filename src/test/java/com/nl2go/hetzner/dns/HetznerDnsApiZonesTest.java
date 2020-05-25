package com.nl2go.hetzner.dns;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
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
public class HetznerDnsApiZonesTest {

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
    public void getZonesReturnsEmptyList() {

        stubFor(get(urlEqualTo("/zones"))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("zones_empty.json")));

        List<Zone> zones = hetznerDNSApiService.listZones().getZones();

        assertEquals(0, zones.size());
    }

    @Test
    public void getZonesReturnsListGreaterThanZero() {

        stubFor(get(urlEqualTo("/zones"))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("zones.json")));

        List<Zone> zones = hetznerDNSApiService.listZones().getZones();

        assertEquals(2, zones.size());
    }

    @Test
    public void getZoneWithIdReturnsZoneWhenZoneExist() {

        stubFor(get(urlEqualTo(format("/zones/{0}", ZONEID)))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("zone.json")));

        Zone zone = hetznerDNSApiService.getZone(ZONEID);

        assertNotNull(zone);

        assertEquals(ZONEID, zone.getId());
        assertEquals(3, zone.getLegacyNs().size());
        assertEquals(12, zone.getRecordsCount());
    }

    @Test
    public void getZoneWithIdReturns404WhenZoneDoesNotExist() {

        String notExistingZoneId = "DoesNotExist";

        stubFor(get(urlEqualTo(format("/zones/{0}", notExistingZoneId)))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .willReturn(aResponse().withStatus(HttpStatus.NOT_FOUND.value())));

        Zone zone = hetznerDNSApiService.getZone(notExistingZoneId);

        assertNull(zone);
    }

    @Test
    public void createZoneWithValidInputCreatesZone() {
        stubFor(post(urlEqualTo("/zones"))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .withRequestBody(equalToJson("{\"name\":\"hetzner-dns-test.de\",\"ttl\":86400}"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("zone.json")));

        ZoneInput zoneInput = getZoneInput();

        Zone zone = hetznerDNSApiService.createZone(zoneInput);

        assertEquals(ZONEID, zone.getId());
        assertEquals("hetzner-dns-test.de", zone.getName());
        assertEquals(86400, zone.getTtl());
    }

    @Test
    public void updateZoneWithValidInputUpdatesZone() {
        stubFor(put(urlEqualTo(format("/zones/{0}", ZONEID)))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .withRequestBody(equalToJson("{\"name\":\"hetzner-dns-test.de\",\"ttl\":86400}"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("zone.json")));

        ZoneInput zoneInput = getZoneInput();

        Zone zone = hetznerDNSApiService.updateZone(zoneInput, ZONEID);

        assertEquals(ZONEID, zone.getId());
        assertEquals("hetzner-dns-test.de", zone.getName());
        assertEquals(86400, zone.getTtl());
    }

    @Test
    public void deleteZoneWithValidIdDeletesZone() {
        stubFor(delete(urlEqualTo(format("/zones/{0}", ZONEID)))
                .withHeader("Auth-API-Token", equalTo(authApiToken))
                .willReturn(aResponse().withStatus(HttpStatus.OK.value())));

        hetznerDNSApiService.deleteZone(ZONEID);
    }

    private ZoneInput getZoneInput() {
        ZoneInput zoneInput = new ZoneInput();
        zoneInput.setName("hetzner-dns-test.de");
        zoneInput.setTtl(86400);
        return zoneInput;
    }
}
