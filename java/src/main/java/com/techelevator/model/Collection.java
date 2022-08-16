package com.techelevator.model;

import com.techelevator.model.MarvelModel.MarvelComic;

import java.util.List;

public class Collection {

    private int collectionId;
    private List<MarvelComic> comics;
    private int userId;
    private String name;

    public Collection() { }

    public Collection(int collectionId, List<MarvelComic> comics, int userId, String name) {
        this.collectionId = collectionId;
        this.comics = comics;
        this.userId = userId;
        this.name = name;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public List<MarvelComic> getComics() {
        return comics;
    }

    public void setComics(List<MarvelComic> comics) {
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
}
