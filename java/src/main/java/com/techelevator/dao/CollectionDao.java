package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {

    Collection getCollectionByCollectionId(int collectionId);

    List<Collection> getAllCollectionsByUserId(int userId);

    Collection createNewCollection(Collection collectionToCreate, int userId);

    void deleteCollectionByCollectionId(int collectionId);

}
