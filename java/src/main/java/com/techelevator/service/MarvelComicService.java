package com.techelevator.service;

import com.techelevator.model.Comic;
import com.techelevator.model.MarvelComic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarvelComicService {

    String marvelApiKey = "?ts=1&apikey=248644f449ac62c68a60d0ecd4fa7dba&hash=c10e02667791a567160a2739bc6849a1";
    String url = "https://gateway.marvel.com/v1/public/comics" + marvelApiKey;

    @Autowired
    private RestTemplate template = new RestTemplate();

    public MarvelComic[] findAllComics() {
        return template.getForObject(url, MarvelComic[].class);
    }

}
