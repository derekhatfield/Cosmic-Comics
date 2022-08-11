package com.techelevator.model.MarvelDataModels;

public class OverallMarvelData {

    private OverallMarvelResults[] results;

    public OverallMarvelData() { }

    public OverallMarvelData(OverallMarvelResults[] results) {
        this.results = results;
    }

    public OverallMarvelResults[] getResults() {
        return results;
    }

    public OverallMarvelData setResults(OverallMarvelResults[] results) {
        this.results = results;
        return this;
    }

}
