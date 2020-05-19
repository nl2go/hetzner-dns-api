package com.nl2go.hetzner.dns.model;

public class Pagination {
    private float lastPage;

    private float nextPage;

    private float page;

    private float perPage;

    private float previousPage;

    private float totalEntries;

    public float getLastPage() {
        return lastPage;
    }

    public void setLastPage(float lastPage) {
        this.lastPage = lastPage;
    }

    public float getNextPage() {
        return nextPage;
    }

    public void setNextPage(float nextPage) {
        this.nextPage = nextPage;
    }

    public float getPage() {
        return page;
    }

    public void setPage(float page) {
        this.page = page;
    }

    public float getPerPage() {
        return perPage;
    }

    public void setPerPage(float perPage) {
        this.perPage = perPage;
    }

    public float getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(float previousPage) {
        this.previousPage = previousPage;
    }

    public float getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(float totalEntries) {
        this.totalEntries = totalEntries;
    }
}
