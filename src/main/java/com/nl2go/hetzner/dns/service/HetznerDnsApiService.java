package com.nl2go.hetzner.dns.service;

import com.nl2go.hetzner.dns.model.Zone;

import java.util.List;

public interface HetznerDnsApiService {

    List<Zone> getZones();

    Zone getZoneById(String id);
}
