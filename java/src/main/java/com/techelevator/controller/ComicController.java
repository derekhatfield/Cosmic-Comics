package com.techelevator.controller;


import com.techelevator.dao.ComicDao;
import com.techelevator.model.Comic;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/comics")
public class ComicController {

    private ComicDao comicDao;

    public ComicController(ComicDao comicDao) {
        this.comicDao = comicDao;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Comic getComicByComicId(@PathVariable int id) {
        return comicDao.getComicByComicId(id);
    }

}
