package com.techelevator.controller;

import com.techelevator.model.Comic;
import com.techelevator.model.MarvelComic;
import com.techelevator.service.MarvelComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/comicstest")
public class MarvelController {

    @Autowired
    private MarvelComicService marvelComicService;

    @GetMapping
    public MarvelComic[] getAllComics() {
        return marvelComicService.findAllComics();
    }

}
