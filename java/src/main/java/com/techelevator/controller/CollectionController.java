package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import com.techelevator.model.MarvelDataModels.OverallMarvel;
import com.techelevator.model.MarvelDataModels.OverallMarvelData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/collections")
public class CollectionController {

    private CollectionDao collectionDao;
    private UserDao userDao;

    public CollectionController(CollectionDao collectionDao, UserDao userDao) {
        this.collectionDao = collectionDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/owner/{username}", method = RequestMethod.GET)
    public OverallMarvel getCollectionsByUsername(@PathVariable String username)  {
        List<Collection> collections;
        collections = collectionDao.getCollectionsByUser(userDao.findIdByUsername(username));
        return new OverallMarvel().setData(new OverallMarvelData().setResultsList(collections).setCount(collections.size()).setTotal(collections.size()));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Collection getCollectionByCollectionId(@PathVariable int id) {
        Collection collection = collectionDao.getCollectionByCollectionId(id);
        return collection;
    }

    @RequestMapping(path = "/{name}/{number}/{page}", method = RequestMethod.GET)
    public OverallMarvel getCollectionsNameNum(@PathVariable String name, @PathVariable int number, @PathVariable int page) {
        List<Collection> collections;
        collections = collectionDao.getCollections(name, number, page);
        return new OverallMarvel().setData(new OverallMarvelData().setResultsList(collections).setCount(collections.size()).setTotal(collectionDao.getCollections("", Integer.MAX_VALUE, 0).size()));
    }

    @RequestMapping(path = "/users/{userId}", method = RequestMethod.POST)
    public void createCollectionByUserId(@RequestBody Collection newCollection, @PathVariable int userId){
        collectionDao.createNewCollection(newCollection);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteCollectionByCollectionId(@PathVariable int id) {
        collectionDao.deleteCollectionByCollectionId(id);
    }

}
