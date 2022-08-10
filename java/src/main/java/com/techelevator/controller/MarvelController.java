package com.techelevator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class MarvelController {

    private static final String MARVEL_API_BASE_URL = "https://gateway.marvel.com/v1/public/";
    private static final String MARVEL_API_PUBLIC_KEY = "248644f449ac62c68a60d0ecd4fa7dba";
    private static final String MARVEL_API_PRIVATE_KEY = "6a0961a46925e2b1524460f0e74c8a24add73d67";
    private static final String MARVEL_API_TS = "1";
    private static final String MARVEL_API_HASH = "c10e02667791a567160a2739bc6849a1";

    /* The pattern for making Marvel API calls is base url + comics/characters/etc + ts + public key + hash */

    private RestTemplate restTemplate = new RestTemplate();

}
