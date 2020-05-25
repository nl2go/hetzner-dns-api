package com.nl2go.hetzner.dns.service;

import com.nl2go.hetzner.dns.model.*;

public interface HetznerDnsApiService {

    ZonesResponse listZones();

    Zone getZone(String zoneId);

    Zone createZone(ZoneInput input);

    Zone updateZone(ZoneInput input, String zoneId);

    void deleteZone(String zoneId);

    RecordsResponse listRecords();

    Record getRecord(String recordId);

    Record createRecord(RecordInput input);

    Record updateRecord(RecordInput input, String recordId);

    void deleteRecord(String recordId);
}
