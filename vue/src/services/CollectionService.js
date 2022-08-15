import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllCollections() {
        return http.get(`/collections`);
    },

    getCollection(id) {
        return http.get(`/collections/${id}`);
    }
}