package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import com.techelevator.model.MarvelDataModels.OverallMarvel;
import com.techelevator.model.MarvelDataModels.OverallMarvelData;
import com.techelevator.model.MarvelDataModels.OverallMarvelResults;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/collections")
@PreAuthorize("isAuthenticated()")
public class CollectionController {

    private CollectionDao collectionDao;
    private UserDao userDao;

    public CollectionController(CollectionDao collectionDao, UserDao userDao) {
        this.collectionDao = collectionDao;
        this.userDao = userDao;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(method = RequestMethod.GET)
    public List<Collection> getAllCollections(Principal principal) {
        List<Collection> collections = collectionDao.getCollections();
        return collections;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/mycollections/{username}", method = RequestMethod.GET)
    public OverallMarvel getCollectionsByUsername(@PathVariable String username, Principal principal)  {
        List<Collection> collections;
        collections = collectionDao.getCollectionsByUser(userDao.findIdByUsername(username));
        collections.addAll(collectionDao.getCollectionsByUser(userDao.findIdByUsername(username)));
        return new OverallMarvel().setData(new OverallMarvelData().setResultsList(collections).setCount(collections.size()).setTotal(collections.size()));
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Collection getCollectionByCollectionId(@PathVariable int id) {
        Collection collection = collectionDao.getCollectionById(id);
        return collection;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{name}/{number}/{page}", method = RequestMethod.GET)
    public OverallMarvel getCollectionsNameNum(@PathVariable String name, @PathVariable int number, @PathVariable int page, Principal principal) {
        List<Collection> collections;
        if (principal == null) {
            collections = collectionDao.getCollections(name, number, page);
        } else {
            collections = collectionDao.getCollections(name, number, page, userDao.findIdByUsername(principal.getName()));
        }

        return new OverallMarvel().setData(new OverallMarvelData().setResultsList(collections).setCount(collections.size()).setTotal(collectionDao.getCollections("", Integer.MAX_VALUE, 0).size()));
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public void addCollection(@RequestBody Collection newCollection, Principal principal){
            collectionDao.addCollection(newCollection.setUserId(userDao.findIdByUsername(principal.getName())));
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
    public void removeCollection(@PathVariable int id, Principal principal) {
        collectionDao.removeCollection(id);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/thumbnail/{id}", method = RequestMethod.GET)
    public String getThumbnail(@PathVariable int id, Principal principal) {
        return collectionDao.getThumbnail(id);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{collectionId}/add/{comicId}", method = RequestMethod.POST)
    public void addComic(@PathVariable int collectionId, @PathVariable int comicId, Principal principal) {
        OverallMarvelResults comic = MarvelController.MarvelComic.getComic(comicId).getData().getResults()[0];
        collectionDao.addComic(comic, collectionId);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{collectionId}/remove/{comicId}", method = RequestMethod.POST)
    public void deleteComic(@PathVariable int collectionId, @PathVariable int comicId, Principal principal) {
        collectionDao.deleteComic(collectionId, comicId);
    }

}
