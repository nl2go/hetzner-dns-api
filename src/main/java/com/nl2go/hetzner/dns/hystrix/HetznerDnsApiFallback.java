package com.nl2go.hetzner.dns.hystrix;

import com.nl2go.hetzner.dns.client.HetznerDnsApiClient;
import com.nl2go.hetzner.dns.model.*;
import org.springframework.stereotype.Component;

@Component
public class HetznerDnsApiFallback implements HetznerDnsApiClient {

    @Override
    public ZonesResponse getZones() {
        return null;
    }

    @Override
    public ZoneResponse getZoneById(String postId) {
        return null;
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
