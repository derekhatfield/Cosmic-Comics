package com.techelevator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.MarvelDataModels.OverallMarvel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@CrossOrigin
public class MarvelController {

    private static final String MARVEL_API_BASE_URL = "https://gateway.marvel.com/v1/public/";
    private static final String MARVEL_API_PUBLIC_KEY = "&apikey=248644f449ac62c68a60d0ecd4fa7dba";
    private static final String MARVEL_API_PRIVATE_KEY = "6a0961a46925e2b1524460f0e74c8a24add73d67";
    private static final String MARVEL_API_TS = "ts=1";
    private static final String MARVEL_API_HASH = "&hash=c10e02667791a567160a2739bc6849a1";

    private static final String MARVEL_COMICS_URL = MARVEL_API_BASE_URL + "comics?" + MARVEL_API_TS + MARVEL_API_PUBLIC_KEY + MARVEL_API_HASH;

    /* The pattern for making Marvel API calls is base url + comics/characters/etc + ts + public key + hash */

    public static RestTemplate restTemplate = new RestTemplate();
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static OverallMarvel getOverallMarvel() {
        try {
            ResponseEntity responseEntity = MarvelController.restTemplate.getForEntity(MARVEL_COMICS_URL, String.class);
            return MarvelController.objectMapper.readValue(MarvelController.objectMapper.createParser((String)responseEntity.getBody()), OverallMarvel.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static abstract class MarvelComic {
        public static OverallMarvel getAllComics() {
            return getOverallMarvel();
        }

    }


}
