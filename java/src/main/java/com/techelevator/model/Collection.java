package com.techelevator.model;

public class Collection {

    private int collectionId;
    private int userId;
    private String name;
    private String visibility;

    public Collection() { }

    public Collection(int collectionId, int userId, String name, String visibility) {
        this.collectionId = collectionId;
        this.userId = userId;
        this.name = name;
        this.visibility = visibility;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
