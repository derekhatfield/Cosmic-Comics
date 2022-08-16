import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:9000"
// });

const baseUrl = `http://gateway.marvel.com/v1/public/`;
const keyUrl = `&ts=1&apikey=248644f449ac62c68a60d0ecd4fa7dba&hash=c10e02667791a567160a2739bc6849a1`;

export default {

    searchByCharacters(characterName) {            
        const characterSearch = `characters?nameStartsWith=${characterName}`;        

        return axios.get(baseUrl + characterSearch + keyUrl);
    },
    
    searchByComics(comicName) {
        const comicSearch = `comics?titleStartsWith=${comicName}`;

        return axios.get(baseUrl + comicSearch + keyUrl);
    }
}