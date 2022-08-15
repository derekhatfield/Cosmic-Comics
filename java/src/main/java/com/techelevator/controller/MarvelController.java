package com.techelevator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.MarvelDataModels.MarvelThumbnail;
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

    /* The pattern for making Marvel API calls is base url + comics/characters/etc + ts + public key + hash */

    public static RestTemplate restTemplate = new RestTemplate();
    public static ObjectMapper objectMapper = new ObjectMapper();

    /* public static String replace(String s, String searchFor, String replacement) {
        for (int i=0; i < s.length() - searchFor.length() + 1; i++) {
            if (s.charAt(i) == searchFor.charAt(0) && s.substring(i, i + searchFor.length()).equals(searchFor)) {
                s = s.substring(0, i) + replacement + s.substring(i + searchFor.length());
                i += replacement.length() - searchFor.length();
            }
        }
        return s;
    }*/

    public static String createURL(String uri) {
        return MARVEL_API_BASE_URL + uri + MARVEL_API_TS + MARVEL_API_PUBLIC_KEY + MARVEL_API_HASH;
    }

    public static OverallMarvel getOverallMarvel(String s) {
        try {
            ResponseEntity responseEntity = MarvelController.restTemplate.getForEntity(MarvelController.createURL(s + (s.indexOf('?') == -1?'?':'&')), String.class);
            return MarvelController.objectMapper.readValue(MarvelController.objectMapper.createParser((String)responseEntity.getBody()), OverallMarvel.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static abstract class MarvelComic {

        public static OverallMarvel getComic(int id) {
            return getOverallMarvel("comics/" + id);
        }

        public static OverallMarvel getAllComics() {
            return getOverallMarvel("comics");
        }

        public static OverallMarvel getComicsByName(String name) {
            // TODO: replace?
            return getOverallMarvel("comics?" + (name.equals("0")?"": "titleStartsWith="+name + "&") + "limit=30");
        }

        public static OverallMarvel getComicsByName(String name, int pageNum) {
            // TODO: replace?
            if (name.equals("0")) {
                name = "";
            }
            return getOverallMarvel("comics?" + (name.equals("0")?"": "titleStartsWith="+name + "&") + "limit=30&offset="+(pageNum*30));
        }

        public static OverallMarvel getComicsByCharacter(int id) {
            return getOverallMarvel("comics?characters=" + id);
        }

        public static OverallMarvel getComicsBySeries(int id) {
            return getOverallMarvel("comics?series=" + id);
        }

        public static String getThumbnailURL(int id) {
            try {
                MarvelThumbnail comicThumbnail = getComic(id).getData().getResults()[0].getThumbnail();
                return comicThumbnail.getPath() + "." + comicThumbnail.getExtension();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "There was an error.";
        }

    }

    public static abstract class Character {

        public static OverallMarvel getCharacter(int id) {
            return getOverallMarvel("characters/" + id);
        }

        public static OverallMarvel getCharacter() {
            return getOverallMarvel("characters");
        }

        public static OverallMarvel getCharactersByName(String name) {
            return getOverallMarvel("characters?nameStartsWith=" + name);
        }

        public static OverallMarvel getCharactersByComic(int id) {
            return getOverallMarvel("characters?comics=" + id);
        }

        public static OverallMarvel getComicsBySeries(int id) {
            return getOverallMarvel("comics?series=" + id);
        }

        public static String getThumbnailURL(int id) {
            try {
                MarvelThumbnail comicThumbnail = getCharacter(id).getData().getResults()[0].getThumbnail();
                return comicThumbnail.getPath() + "." + comicThumbnail.getExtension();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "There was an error.";
        }

    }

    public static abstract class Creator {

        public static OverallMarvel getCreatorByComicId(int id) {
            return getOverallMarvel("creators?comics=" + id);
        }

    }


}
