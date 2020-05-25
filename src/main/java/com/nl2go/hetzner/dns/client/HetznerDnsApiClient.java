package com.nl2go.hetzner.dns.client;

import com.nl2go.hetzner.dns.config.ClientConfiguration;
import com.nl2go.hetzner.dns.hystrix.HetznerDnsApiFallback;
import com.nl2go.hetzner.dns.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "hetzner-dns-api",
        url = "${hetzner-dns-api.url}",
        configuration = ClientConfiguration.class,
        fallback = HetznerDnsApiFallback.class)
public interface HetznerDnsApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/zones")
    ZonesResponse getZones();

    @RequestMapping(method = RequestMethod.GET, value = "/zones/{zoneId}", produces = "application/json")
    ZoneResponse getZoneById(@PathVariable("zoneId") String zoneId);

    @RequestMapping(method = RequestMethod.POST, value = "/zones", consumes = {"application/json"}, produces = "application/json")
    ZoneResponse postZoneById(@RequestBody ZoneInput input, @PathVariable("zoneId") String zoneId);

    @RequestMapping(method = RequestMethod.PUT, value = "/zones/{zoneId}", consumes = {"application/json"}, produces = "application/json")
    ZoneResponse putZoneById(@RequestBody ZoneInput input, @PathVariable("zoneId") String zoneId);

    @RequestMapping(method = RequestMethod.DELETE, value = "/zones/{zoneId}", produces = "application/json")
    void deleteZoneById(@PathVariable("zoneId") String zoneId);

    @RequestMapping(method = RequestMethod.GET, value = "/records")
    RecordsResponse getRecords();

    @RequestMapping(method = RequestMethod.GET, value = "/records/{recordId}", produces = "application/json")
    RecordResponse getRecordById(@PathVariable("recordId") String recordId);

    @RequestMapping(method = RequestMethod.POST, value = "/records", consumes = {"application/json"}, produces = "application/json")
    RecordResponse postRecordById(@RequestBody RecordInput input, @PathVariable("recordId") String recordId);

    @RequestMapping(method = RequestMethod.PUT, value = "/records/{recordId}", consumes = {"application/json"}, produces = "application/json")
    RecordResponse putRecordById(@RequestBody RecordInput input, @PathVariable("recordId") String recordId);

    @RequestMapping(method = RequestMethod.DELETE, value = "/records/{recordId}", produces = "application/json")
    void deleteRecordById(@PathVariable("recordId") String recordId);
}
