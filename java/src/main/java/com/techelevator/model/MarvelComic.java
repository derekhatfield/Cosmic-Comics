package com.techelevator.model;

public class MarvelComic {

    private int id;
    private String title;
    private String seriesName;
    private String creatorsItemsName;
    private int issueNumber;

    public MarvelComic() { }

    public MarvelComic(int id, String title, String seriesName, String creatorsItemsName, int issueNumber) {
        this.id = id;
        this.title = title;
        this.seriesName = seriesName;
        this.creatorsItemsName = creatorsItemsName;
        this.issueNumber = issueNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getCreatorsItemsName() {
        return creatorsItemsName;
    }

    public void setCreatorsItemsName(String creatorsItemsName) {
        this.creatorsItemsName = creatorsItemsName;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
}
