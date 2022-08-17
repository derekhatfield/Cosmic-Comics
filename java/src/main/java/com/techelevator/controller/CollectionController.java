package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import com.techelevator.model.MarvelModel.MarvelComic;
import com.techelevator.services.MarvelComicService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/collections")
@PreAuthorize("isAuthenticated()")
public class CollectionController {

    private CollectionDao collectionDao;
    private UserDao userDao;
    private MarvelComicService marvelComicService;

    public CollectionController(CollectionDao collectionDao, UserDao userDao, MarvelComicService marvelComicService) {
        this.collectionDao = collectionDao;
        this.userDao = userDao;
        this.marvelComicService = marvelComicService;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(method = RequestMethod.GET)
    public List<Collection> getAllCollections(Principal principal) {
        List<Collection> collections = collectionDao.getCollections();
        return collections;
    }

    /*@PreAuthorize("permitAll()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Collection getCollectionByCollectionId(@PathVariable int id) {
        Collection collection = collectionDao.getCollectionById(id);
        return collection;
    }*/

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public List<Collection> getMyCollections(@PathVariable String username) {
        List<Collection> collections = collectionDao.getCollectionsByUserId(userDao.findIdByUsername(username));
        return collections;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public void addCollection(@RequestBody Collection newCollection, Principal principal){
            collectionDao.addCollection(newCollection);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
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
    public void addComic(@Valid @RequestBody MarvelComic comic, @PathVariable int collectionId, @PathVariable int comicId) {

        collectionDao.addComic(comicId, collectionId, comic.getComicTitle(), comic.getImageURL());
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{collectionId}/remove/{comicId}", method = RequestMethod.DELETE)
    public void deleteComic(@PathVariable int collectionId, @PathVariable int comicId, Principal principal) {
        collectionDao.deleteComic(collectionId, comicId);
    }

}
