import axios from 'axios';

const marvel = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    searchByCharacters(characterName) {            
        return marvel.get(`/characters/name/${characterName}`);
    },
    
    searchByComics(comicName) {
        return marvel.get(`/comic/bytitle/${comicName}`);
    }
}