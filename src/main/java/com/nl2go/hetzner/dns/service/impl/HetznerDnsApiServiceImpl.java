package com.nl2go.hetzner.dns.service.impl;

import com.nl2go.hetzner.dns.client.HetznerDnsApiClient;
import com.nl2go.hetzner.dns.model.*;
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
        ZonesResponse zonesResponse = new ZonesResponse();
        ZonesResponse zonesResponseResult = hetznerDnsApiClient.getZones();

        if (zonesResponseResult != null) {
            zonesResponse = zonesResponseResult;
        }

        return zonesResponse.getZones();
    }

    @Override
    public Zone getZoneById(String id) {
        ZoneResponse zoneResponse = new ZoneResponse();
        ZoneResponse zoneResponseResult = hetznerDnsApiClient.getZoneById(id);

        if (zoneResponseResult != null) {
            zoneResponse = zoneResponseResult;
        }

        return zoneResponse.getZone();
    }

    @Override
    public ZoneResponse postZoneById(ZoneInput input, String zoneId) {
        return null;
    }

    @Override
    public ZoneResponse putZoneById(ZoneInput input, String zoneId) {
        return null;
    }

    @Override
    public void deleteZoneById(String zoneId) {

    }

    @Override
    public RecordsResponse getRecords() {
        return null;
    }

    @Override
    public RecordResponse getRecordById(String recordId) {
        return null;
    }

    @Override
    public RecordResponse postRecordById(RecordInput input, String recordId) {
        return null;
    }

    @Override
    public RecordResponse putRecordById(RecordInput input, String recordId) {
        return null;
    }

    @Override
    public void deleteRecordById(String recordId) {

    }
}


