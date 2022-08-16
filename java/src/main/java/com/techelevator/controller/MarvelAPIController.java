package com.techelevator.controller;

// ********************************************************************************
// NOTE: THIS CODE HAS BEEN PROVIDED BY INSTRUCTOR R.SEEDS FOR ACCESS TO MARVEL API
//       DUE TO A LAST MINUTE FAILURE OF INITIAL CONTROLLER INTEGRATION. SOURCED
//       FROM PHL[6] TEAM[1]
// ********************************************************************************

import com.techelevator.dao.ComicDao;
import com.techelevator.model.MarvelModel.MarvelComic;
import com.techelevator.services.MarvelComicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController

public class MarvelAPIController {

    String Api_Base_URL = "http://gateway.marvel.com/v1/public";

    private ComicDao comicDao;
    private MarvelComicService marvelComicService;

    public MarvelAPIController(ComicDao comicDao, MarvelComicService marvelComicService) {
        this.comicDao = comicDao;
        this.marvelComicService = marvelComicService;
    }

    @RequestMapping(path ="/comics", method = RequestMethod.GET)
    public List<MarvelComic> listAllComics() {
        return marvelComicService.getAllComics();
    }
    // List comics by character name
    @RequestMapping(path = "/characters/name/{characterName}", method = RequestMethod.GET)
    public List<MarvelComic> getAllComicsByCharacterName(@PathVariable String characterName) {
        return marvelComicService.getComicListByCharacterName(characterName);}
    // List comics by creator provided
    @RequestMapping(path = "/creators/name/{creatorName}", method = RequestMethod.GET)
    public List<MarvelComic> getComicsByCreatorName(@PathVariable String creatorName) {
        return marvelComicService.getComicByCreatorName(creatorName);}
    // List comics by title provided
    @RequestMapping(path = "/comic/bytitle/{title}", method = RequestMethod.GET)
    public List<MarvelComic> getComicsByTitle(@PathVariable String title) {
        return marvelComicService.getComicByTitle(title);}
    // List comics by series provided
    @RequestMapping(path = "/comic/byseries/{seriesName}", method = RequestMethod.GET)
    public List<MarvelComic> getComicsBySeries(@PathVariable String seriesName) {
        return marvelComicService.getComicBySeriesName(seriesName);}
    // List comics that came out this month so far
    @RequestMapping(path ="/comics/date/thisMonth", method = RequestMethod.GET)
    public List<MarvelComic> listThisMonthsComics() {return marvelComicService.getThisMonthsComics();}
    // List comics that came out last week
    @RequestMapping(path ="/comics/date/lastWeek", method = RequestMethod.GET)
    public List<MarvelComic> listLastWeeksComics() {return marvelComicService.getLastWeeksComics();}
    // List comics that came out this week
    @RequestMapping(path ="/comics/date/thisWeek", method = RequestMethod.GET)
    public List<MarvelComic> listThisWeeksComics() {return marvelComicService.getThisWeeksComics();}
    // List comics that come out next week
    @RequestMapping(path ="/comics/date/nextWeek", method = RequestMethod.GET)
    public List<MarvelComic> listNextWeeksComics() {return marvelComicService.getNextWeeksComics();}




}