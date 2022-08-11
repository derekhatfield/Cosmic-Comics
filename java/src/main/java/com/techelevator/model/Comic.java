package com.techelevator.model;

public class Comic {

    private int comicId;
    private String comicAuthor;
    private int comicIssue;
    private String comicTitle;
    private String comicSeries;
    private String comicThumbnailUrl;

    public Comic() { }

    public Comic(int comicId, String comicAuthor, int comicIssue, String comicTitle, String comicSeries, String comicThumbnailUrl) {
        this.comicId = comicId;
        this.comicAuthor = comicAuthor;
        this.comicIssue = comicIssue;
        this.comicTitle = comicTitle;
        this.comicSeries = comicSeries;
        this.comicThumbnailUrl = comicThumbnailUrl;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getComicAuthor() {
        return comicAuthor;
    }

    public void setComicAuthor(String comicAuthor) {
        this.comicAuthor = comicAuthor;
    }

    public int getComicIssue() {
        return comicIssue;
    }

    public void setComicIssue(int comicIssue) {
        this.comicIssue = comicIssue;
    }

    public String getComicTitle() {
        return comicTitle;
    }

    public void setComicTitle(String comicTitle) {
        this.comicTitle = comicTitle;
    }

    public String getComicSeries() {
        return comicSeries;
    }

    public void setComicSeries(String comicSeries) {
        this.comicSeries = comicSeries;
    }

    public String getComicThumbnailUrl() {
        return comicThumbnailUrl;
    }

    public void setComicThumbnailUrl(String comicThumbnailUrl) {
        this.comicThumbnailUrl = comicThumbnailUrl;
    }
}
