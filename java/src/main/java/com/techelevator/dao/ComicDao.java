package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;

public interface ComicDao {

    Comic getComicByComicId(int comicId);

}
