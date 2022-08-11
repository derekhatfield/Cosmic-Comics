package com.techelevator.model.MarvelDataModels;

public class MarvelCreators {

    private MarvelItemsCreators items;

    public MarvelCreators() { }

    public MarvelCreators(MarvelItemsCreators items) {
        this.items = items;
    }

    public MarvelItemsCreators getItems() {
        return items;
    }

    public void setItems(MarvelItemsCreators items) {
        this.items = items;
    }
}
