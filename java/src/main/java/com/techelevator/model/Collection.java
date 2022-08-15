package com.techelevator.model;

import com.techelevator.model.MarvelDataModels.OverallMarvelResults;

import java.util.List;

public class Collection extends OverallMarvelResults {

    private List<OverallMarvelResults> comics;
    private int userId;
    private String name;

    public Collection() { }

    public Collection(int id, List<OverallMarvelResults> comics, int userId, String name) {
        super();
        super.setId(id);
        this.comics = comics;
        this.userId = userId;
        this.name = name;
    }

    public List<OverallMarvelResults> getComicsIds() {
        return comics;
    }

    public void setComics(List<OverallMarvelResults> comics) {
        this.comics = comics;
    }

    public int getUserId() {
        return userId;
    }

    public Collection setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection addComics(List<OverallMarvelResults> comicsToAdd) {
        this.comics.addAll(comicsToAdd);
        return this;
    }

    public Collection removeComics(List<OverallMarvelResults> comicsToRemove) {
        for (int i=0; i < this.comics.size(); i++) {
            if (comicsToRemove.contains(this.comics.get(i))) {
                this.comics.remove(i--);
            }
        }
        return this;
    }
}
