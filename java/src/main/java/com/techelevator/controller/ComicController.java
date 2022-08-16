package com.techelevator.controller;


import com.techelevator.dao.ComicDao;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@CrossOrigin(origins = "https://gateway.marvel.com/*")
@RequestMapping("/comics")
@PreAuthorize("isAuthenticated()")
public class ComicController {

    private ComicDao comicDao;

    public ComicController(ComicDao comicDao) {
        this.comicDao = comicDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/thumbnail/{comicId}", method = RequestMethod.GET)
    public String getThumbnail(@PathVariable int comicId, Principal principal) {
        return comicDao.getThumbnailById(comicId);
    }

}
