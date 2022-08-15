package com.techelevator.controller;


import com.techelevator.dao.ComicDao;
import com.techelevator.model.Comic;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/comics")
public class ComicController {

    private ComicDao comicDao;

    public ComicController(ComicDao comicDao) {
        this.comicDao = comicDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/thumbnail/{comicId}", method = RequestMethod.GET)
    public String getThumbnail(@PathVariable int comicId) {
        return comicDao.getThumbnailById(comicId);
    }

}
