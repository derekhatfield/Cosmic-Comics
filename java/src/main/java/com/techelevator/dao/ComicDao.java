package com.techelevator.dao;

import com.techelevator.model.Comic;

public interface ComicDao {

    Comic getComicByComicId(int comicId);

    Comic addComicByComicId(Comic comicToAdd, int comidId);

    void removeComicByComicId(int comicId);

}
