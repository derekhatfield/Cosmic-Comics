import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllCollections() {
        return http.get(`/Collection`);
    },

    getCollection(id) {
        return http.get(`/Collections/${id}`);
    }
}