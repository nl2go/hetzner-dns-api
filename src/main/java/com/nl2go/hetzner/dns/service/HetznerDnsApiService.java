package com.nl2go.hetzner.dns.service;

import com.nl2go.hetzner.dns.model.*;

public interface HetznerDnsApiService {

    ZonesResponse getZonesResponse();

    Zone getZoneById(String zoneId);

    Zone postZoneById(ZoneInput input, String zoneId);

    Zone putZoneById(ZoneInput input, String zoneId);

    void deleteZoneById(String zoneId);

    RecordsResponse getRecordsResponse();

    Record getRecordById(String recordId);

    Record postRecordById(RecordInput input, String recordId);

    Record putRecordById(RecordInput input, String recordId);

    void deleteRecordById(String recordId);
}
