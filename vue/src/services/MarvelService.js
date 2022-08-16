import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:9000"
// });

       
export default {

        searchByCharacters (characterName){   
        
        const baseUrl = `http://gateway.marvel.com/v1/public/`;
    
        const characterSearch = `characters?nameStartsWith=${characterName}`;

        const keyUrl = `&ts=1&apikey=248644f449ac62c68a60d0ecd4fa7dba&hash=c10e02667791a567160a2739bc6849a1`;

        return axios.get(baseUrl + characterSearch + keyUrl);

    } 
}