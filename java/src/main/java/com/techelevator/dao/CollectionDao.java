package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.MarvelDataModels.OverallMarvelResults;

import java.util.List;

public interface CollectionDao {

    Collection getCollectionById(int collectionId);

    List<Collection> getCollections();

    List<Collection> getCollections(String sql, Object[] args, int[] types);

    List<Collection> getCollections(String name, int limit, int page, int userId);

    List<Collection> getCollections(String name, int limit, int page);

    List<Collection> getCollectionsByUser(int userId);

    void addCollection(Collection collectionToCreate);

    void removeCollection(int collectionId);

    void addComic(OverallMarvelResults newComic, int collectionId);

    void deleteComic(int collectionId, int comicId);

    int getCollectionOwnerId(int collectionId);

    List<Collection> getCollectionsByUserId(int userId);

    void addComicToCollection(OverallMarvelResults comicToAdd, int collectionId);

    void deleteComicFromCollection(int collectionId, int comicId);

    int getCollectionOwner(int collectionId);

    String getThumbnail(int collectionId);

}
