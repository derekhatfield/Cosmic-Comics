package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.MarvelModel.MarvelComic;

import java.util.List;

public interface CollectionDao {

    Collection getCollectionById(int collectionId);

    List<Collection> getCollections();

    List<Collection> getCollections(String sql, Object[] args, int[] types);

    List<Collection> getCollections(String name, int limit, int page, int userId);

    List<Collection> getCollections(String name, int limit, int page);

    void addCollection(Collection collectionToCreate);

    void removeCollection(int collectionId);

    void addComic(int comicId, int collectionId, String comicTitle, String comicURL);

    void deleteComic(int collectionId, int comicId);

    int getCollectionOwnerId(int collectionId);

    List<Collection> getCollectionsByUserId(int userId);

    int getCollectionOwner(int collectionId);

    String getThumbnail(int collectionId);

}
