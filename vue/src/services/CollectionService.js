import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllCollections() {
        return http.get(`/collections`);
    },

    getCollectionById(id) {
        return http.get(`/collections/${id}`);
    },

    getCollectionsByUsername(username) {
        return http.get(`/collections/mycollections/${username}`);
    },

    addCollection(collection) {
        return http.post('/collections/create', collection);
    }

}