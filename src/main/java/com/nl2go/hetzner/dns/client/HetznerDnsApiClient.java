package com.nl2go.hetzner.dns.client;

import com.nl2go.hetzner.dns.config.ClientConfiguration;
import com.nl2go.hetzner.dns.hystrix.HetznerDnsApiFallback;
import com.nl2go.hetzner.dns.model.GetZoneResponse;
import com.nl2go.hetzner.dns.model.Zone;
import com.nl2go.hetzner.dns.model.GetZonesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "hetzner-dns-api",
        url = "${hetzner-dns-api.url}",
        configuration = ClientConfiguration.class,
        fallback = HetznerDnsApiFallback.class)
public interface HetznerDnsApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/zones")
    GetZonesResponse getZones();


    @RequestMapping(method = RequestMethod.GET, value = "/zones/{zoneId}", produces = "application/json")
    GetZoneResponse getZoneById(@PathVariable("zoneId") String zoneId);
}
