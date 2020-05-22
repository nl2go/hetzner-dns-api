package com.nl2go.hetzner.dns.model;

import java.util.ArrayList;

    public class RecordsResponse {
        private Meta Meta;

        private ArrayList<Record> records = new ArrayList<>();

        public Meta getMeta() {
            return Meta;
        }

        public void setMeta(Meta meta) {
            Meta = meta;
        }

        public ArrayList<Record> getRecords() {
            return records;
        }

        public void setZones(ArrayList<Record> records) {
            this.records = records;
        }
    }
