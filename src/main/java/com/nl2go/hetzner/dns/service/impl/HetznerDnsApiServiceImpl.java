package com.nl2go.hetzner.dns.service.impl;

import com.nl2go.hetzner.dns.client.HetznerDnsApiClient;
import com.nl2go.hetzner.dns.model.*;
import com.nl2go.hetzner.dns.service.HetznerDnsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HetznerDnsApiServiceImpl implements HetznerDnsApiService {

    @Autowired
    private HetznerDnsApiClient hetznerDnsApiClient;

    @Override
    public ZonesResponse getZonesResponse() {
        return hetznerDnsApiClient.getZones();
    }

    @Override
    public Zone getZoneById(String zoneId) {
        ZoneResponse zoneResponse = new ZoneResponse();
        ZoneResponse zoneResponseResult = hetznerDnsApiClient.getZoneById(zoneId);

        if (zoneResponseResult != null) {
            zoneResponse = zoneResponseResult;
        }

        return zoneResponse.getZone();
    }

    @Override
    public Zone postZoneById(ZoneInput input, String zoneId) {
        return null;
    }

    @Override
    public Zone putZoneById(ZoneInput input, String zoneId) {
        return null;
    }

    @Override
    public void deleteZoneById(String zoneId) {

    }

    @Override
    public RecordsResponse getRecordsResponse() {
        return hetznerDnsApiClient.getRecords();
    }

    @Override
    public Record getRecordById(String recordId) {
        RecordResponse recordResponse = new RecordResponse();
        RecordResponse recordResponseResult = hetznerDnsApiClient.getRecordById(recordId);

        if (recordResponseResult != null) {
            recordResponse = recordResponseResult;
        }

        return recordResponse.getRecord();
    }

    @Override
    public Record postRecordById(RecordInput input, String recordId) {
        return null;
    }

    @Override
    public Record putRecordById(RecordInput input, String recordId) {
        return null;
    }

    @Override
    public void deleteRecordById(String recordId) {

    }
}


