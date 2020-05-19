package com.nl2go.hetzner.dns.model;

import java.util.ArrayList;

public class Zone {
    private String created;
    private String id;
    private boolean isSecondaryDns;
    private String legacyDnsHost;
    private ArrayList<String> legacyNs = new ArrayList<>();
    private String modified;
    private String name;
    private ArrayList<String> ns = new ArrayList<>();
    private String owner;
    private boolean paused;
    private String permission;
    private String project;
    private int recordsCount;
    private String registrar;
    private String status;
    private float ttl;
    private TxtVerification TxtVerificationObject;
    private String verified;
    private ZoneType ZoneTypeObject;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIsSecondaryDns() {
        return isSecondaryDns;
    }

    public void setIsSecondaryDns(boolean isSecondaryDns) {
        this.isSecondaryDns = isSecondaryDns;
    }

    public String getLegacyDnsHost() {
        return legacyDnsHost;
    }

    public void setLegacyDnsHost(String legacyDnsHost) {
        this.legacyDnsHost = legacyDnsHost;
    }

    public ArrayList<String> getLegacyNs() {
        return legacyNs;
    }

    public void setLegacyNs(ArrayList<String> legacyNs) {
        this.legacyNs = legacyNs;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getNs() {
        return ns;
    }

    public void setNs(ArrayList<String> ns) {
        this.ns = ns;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getRecordsCount() {
        return recordsCount;
    }

    public void setRecordsCount(int recordsCount) {
        this.recordsCount = recordsCount;
    }

    public String getRegistrar() {
        return registrar;
    }

    public void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTtl() {
        return ttl;
    }

    public void setTtl(float ttl) {
        this.ttl = ttl;
    }

    public TxtVerification getTxtVerificationObject() {
        return TxtVerificationObject;
    }

    public void setTxtVerificationObject(TxtVerification txtVerificationObject) {
        TxtVerificationObject = txtVerificationObject;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public ZoneType getZoneTypeObject() {
        return ZoneTypeObject;
    }

    public void setZoneTypeObject(ZoneType zoneTypeObject) {
        ZoneTypeObject = zoneTypeObject;
    }
}


