package com.techelevator.dao;

import com.techelevator.model.MarvelDataModels.OverallMarvelResults;

import java.util.List;

public interface ComicDao {

    OverallMarvelResults getComicByComicId(int comicId);

    //OverallMarvelResults addComic(int comicId);

    //OverallMarvelResults removeComic(int comicId);

    //List<OverallMarvelResults> getComicsByCharacter(int characterId);

    //List<OverallMarvelResults> getComicsByAuthor(int authorId);

    boolean hasAuthor(int comicId, int authorId);

    List<OverallMarvelResults> getComicsByCollectionId(int collectionId);

    String getThumbnailById(int id);

}
