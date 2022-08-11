package com.techelevator.model.MarvelDataModels;

public class OverallMarvelResults {

    private int id;
    private String title;
    private int issueNumber;
    private MarvelURLs urls;
    private MarvelSeries series;
    private MarvelThumbnail thumbnail;
    private MarvelCreators creators;

    public OverallMarvelResults() { }

    public OverallMarvelResults(int id, String title, int issueNumber, MarvelURLs urls, MarvelSeries series, MarvelThumbnail thumbnail, MarvelCreators creators) {
        this.id = id;
        this.title = title;
        this.issueNumber = issueNumber;
        this.urls = urls;
        this.series = series;
        this.thumbnail = thumbnail;
        this.creators = creators;
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

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public MarvelURLs getUrls() {
        return urls;
    }

    public void setUrls(MarvelURLs urls) {
        this.urls = urls;
    }

    public MarvelSeries getSeries() {
        return series;
    }

    public void setSeries(MarvelSeries series) {
        this.series = series;
    }

    public MarvelThumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(MarvelThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public MarvelCreators getCreators() {
        return creators;
    }

    public void setCreators(MarvelCreators creators) {
        this.creators = creators;
    }
}
