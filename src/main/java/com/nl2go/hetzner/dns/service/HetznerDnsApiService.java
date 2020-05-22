package com.nl2go.hetzner.dns.service;

import com.nl2go.hetzner.dns.model.*;

import java.util.List;

public interface HetznerDnsApiService {

    List<Zone> getZones();

    Zone getZoneById(String zoneId);

    ZoneResponse postZoneById(ZoneInput input, String zoneId);

    ZoneResponse putZoneById(ZoneInput input, String zoneId);

    void deleteZoneById(String zoneId);

    RecordsResponse getRecords();

    RecordResponse getRecordById(String recordId);

    RecordResponse postRecordById(RecordInput input, String recordId);

    RecordResponse putRecordById(RecordInput input, String recordId);

    void deleteRecordById(String recordId);
}
