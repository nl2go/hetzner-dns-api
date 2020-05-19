package com.nl2go.hetzner.dns.service.impl;

import com.nl2go.hetzner.dns.client.HetznerDnsApiClient;
import com.nl2go.hetzner.dns.model.GetZoneResponse;
import com.nl2go.hetzner.dns.model.GetZonesResponse;
import com.nl2go.hetzner.dns.model.Zone;
import com.nl2go.hetzner.dns.service.HetznerDnsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HetznerDnsApiServiceImpl implements HetznerDnsApiService {

    @Autowired
    private HetznerDnsApiClient hetznerDnsApiClient;

    @Override
    public List<Zone> getZones() {
        GetZonesResponse zonesResponse = hetznerDnsApiClient.getZones();
        return zonesResponse.getZones();
    }

    @Override
    public Zone getZoneById(String id) {
        GetZoneResponse zoneResponse = hetznerDnsApiClient.getZoneById(id);
        return zoneResponse.getZone();
    }
}


