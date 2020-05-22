package com.nl2go.hetzner.dns.model;

import java.util.ArrayList;

public class ZonesResponse {
    Meta Meta;

    ArrayList<Zone> zones = new ArrayList<>();

    public Meta getMeta() {
        return Meta;
    }

    public void setMeta(Meta meta) {
        Meta = meta;
    }

    public ArrayList<Zone> getZones() {
        return zones;
    }

    public void setZones(ArrayList<Zone> zones) {
        this.zones = zones;
    }
}