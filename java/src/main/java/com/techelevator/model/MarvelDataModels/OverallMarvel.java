package com.techelevator.model.MarvelDataModels;

public class OverallMarvel {

    private OverallMarvelData data;

    public OverallMarvel() { }

    public OverallMarvel(OverallMarvelData data) {
        this.data = data;
    }

    public OverallMarvelData getData() {
        return data;
    }

    public OverallMarvel setData(OverallMarvelData data) {
        this.data = data;
        return this;
    }
}
