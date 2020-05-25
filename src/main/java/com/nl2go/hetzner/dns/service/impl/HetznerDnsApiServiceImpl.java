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
    public ZonesResponse listZones() {
        return hetznerDnsApiClient.getZones();
    }

    @Override
    public Zone getZone(String zoneId) {
        ZoneResponse zoneResponse = new ZoneResponse();
        ZoneResponse zoneResponseResult = hetznerDnsApiClient.getZoneById(zoneId);

        if (zoneResponseResult != null) {
            zoneResponse = zoneResponseResult;
        }

        return zoneResponse.getZone();
    }

    @Override
    public Zone createZone(ZoneInput input) {
        ZoneResponse zoneResponse = new ZoneResponse();
        ZoneResponse zoneResponseResult = hetznerDnsApiClient.postZone(input);

        if (zoneResponseResult != null) {
            zoneResponse = zoneResponseResult;
        }

        return zoneResponse.getZone();
    }

    @Override
    public Zone updateZone(ZoneInput input, String zoneId) {
        ZoneResponse zoneResponse = new ZoneResponse();
        ZoneResponse zoneResponseResult = hetznerDnsApiClient.putZoneById(input, zoneId);

        if (zoneResponseResult != null) {
            zoneResponse = zoneResponseResult;
        }

        return zoneResponse.getZone();
    }

    @Override
    public void deleteZone(String zoneId) {
        hetznerDnsApiClient.deleteZoneById(zoneId);
    }

    @Override
    public RecordsResponse listRecords() {
        return hetznerDnsApiClient.getRecords();
    }

    @Override
    public Record getRecord(String recordId) {
        RecordResponse recordResponse = new RecordResponse();
        RecordResponse recordResponseResult = hetznerDnsApiClient.getRecordById(recordId);

        if (recordResponseResult != null) {
            recordResponse = recordResponseResult;
        }

        return recordResponse.getRecord();
    }

    @Override
    public Record createRecord(RecordInput input) {
        RecordResponse recordResponse = new RecordResponse();
        RecordResponse recordResponseResult = hetznerDnsApiClient.postRecord(input);

        if (recordResponseResult != null) {
            recordResponse = recordResponseResult;
        }

        return recordResponse.getRecord();
    }

    @Override
    public Record updateRecord(RecordInput input, String recordId) {
        RecordResponse recordResponse = new RecordResponse();
        RecordResponse recordResponseResult = hetznerDnsApiClient.putRecordById(input, recordId);

        if (recordResponseResult != null) {
            recordResponse = recordResponseResult;
        }

        return recordResponse.getRecord();
    }

    @Override
    public void deleteRecord(String recordId) {
        hetznerDnsApiClient.deleteZoneById(recordId);
    }
}


