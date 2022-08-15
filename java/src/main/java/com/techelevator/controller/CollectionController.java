package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Collection getCollectionByCollectionId(@PathVariable int id) {
        return collectionDao.getCollectionByCollectionId(id);
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
