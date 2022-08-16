import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    searchComicsByName(name) {
        return http.get(`/comics/query/title/${name}`);
    },

    gotoNextPageOfSearch(name, page) {
        return http.get(`/comics/query/title/${name}${page}`);
    },

    searchComicsById(id) {
        return http.get(`/comics/query/id/${id}`);
    },

    getThumbnail(id) {
        return http.get(`/comics/thumbnail/${id}`);
    }
}