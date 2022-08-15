package com.techelevator.dao;

import com.techelevator.model.MarvelDataModels.OverallMarvelResults;

import java.util.List;

public interface ComicDao {

    OverallMarvelResults getComicByComicId(int comicId);

    //OverallMarvelResults addComicByComicId(int comicId);

    //OverallMarvelResults removeComicByComicId(int comicId);

    List<OverallMarvelResults> getComicsByCollectionId(int collectionId);

    String getThumbnailById(int id);

}
