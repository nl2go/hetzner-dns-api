package com.nl2go.hetzner.dns.hystrix;

import com.nl2go.hetzner.dns.client.HetznerDnsApiClient;
import com.nl2go.hetzner.dns.model.GetZoneResponse;
import com.nl2go.hetzner.dns.model.GetZonesResponse;
import org.springframework.stereotype.Component;

@Component
public class HetznerDnsApiFallback implements HetznerDnsApiClient {

    @Override
    public GetZonesResponse getZones() {
        return null;
    }

    @Override
    public GetZoneResponse getZoneById(String postId) {
        return null;
    }
}
