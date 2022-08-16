package com.techelevator.dao;


import com.techelevator.model.MarvelModel.MarvelComic;

import java.util.List;

public interface ComicDao {

    MarvelComic getComicByComicId(int comicId);

    //OverallMarvelResults addComic(int comicId);

    //OverallMarvelResults removeComic(int comicId);

    //List<OverallMarvelResults> getComicsByCharacter(int characterId);

    //List<OverallMarvelResults> getComicsByAuthor(int authorId);

    boolean hasAuthor(int comicId, int authorId);

    List<MarvelComic> getComicsByCollectionId(int collectionId);

    String getThumbnailById(int id);

}
