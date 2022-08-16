/*package com.techelevator.model.MarvelDataModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverallMarvelData {

    private int offset;
    private int limit;
    private int total;
    private int count;
    private OverallMarvelResults[] results;

    public OverallMarvelData() { }

    public OverallMarvelData(int offset, int limit, int total, int count, OverallMarvelResults[] results) {
        super();
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.results = results;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public OverallMarvelData setTotal(int total) {
        this.total = total;
        return this;
    }

    public int getCount() {
        return count;
    }

    public OverallMarvelData setCount(int count) {
        this.count = count;
        return this;
    }

    public OverallMarvelResults[] getResults() {
        return results;
    }

    public OverallMarvelData setResults(OverallMarvelResults[] results) {
        this.results = results;
        return this;
    }

    public OverallMarvelData setResultsList(List<?> results) {
        OverallMarvelResults[] marvelResults = new OverallMarvelResults[results.size()];
        for (int i=0; i < results.size(); i++) {
            marvelResults[i] = (OverallMarvelResults) results.get(i);
        }
        this.results = marvelResults;
        return this;
    }
}*/
