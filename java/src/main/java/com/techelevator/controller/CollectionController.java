package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.model.Collection;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/collections")
public class CollectionController {

    //TODO: Check paths to align with front end

    private CollectionDao collectionDao;

    public CollectionController(CollectionDao collectionDao) {
        this.collectionDao = collectionDao;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Collection getCollectionByCollectionId(@PathVariable int id) {
        return collectionDao.getCollectionByCollectionId(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public Collection createCollection(@RequestBody Collection newCollection, @PathVariable int userId){
        return collectionDao.createNewCollection(newCollection, userId);
    }

}
