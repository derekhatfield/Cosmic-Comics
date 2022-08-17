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

    getMyCollections(username) {
        return http.get(`/collections/${username}`);
    },

    addCollection(collection) {
        return http.post('/collections/create', collection);
    },

    deleteCollection(id) {
        return http.post(`/collections/delete/${id}`);
    },

    getCollectionThumbnail(id) {
        return http.get(`/collections/thumbnail/${id}`);
    },

    addComicToCollection(collectionId, comicId) {
        return http.post(`/collections/${collectionId}/add/${comicId}`);
    },

    removeComicFromCollection(collectionId, comicId) {
        return http.post(`/collections/${collectionId}/remove/${comicId}`);
    }

}