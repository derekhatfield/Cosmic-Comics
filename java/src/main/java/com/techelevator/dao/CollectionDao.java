package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.MarvelDataModels.OverallMarvelResults;

import java.util.List;

public interface CollectionDao {

    Collection getCollectionByCollectionId(int collectionId);

    void createNewCollection(Collection collectionToCreate);

    void deleteCollectionByCollectionId(int collectionId);

    List<Collection> getCollectionsByUserId(int userId);

    void addComicToCollection(OverallMarvelResults comicToAdd, int collectionId);

    void deleteComicFromCollection(int collectionId, int comicId);

    int getCollectionOwner(int collectionId);

    String getThumbnail(int collectionId);

}
