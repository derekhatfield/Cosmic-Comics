import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getCollection(id) {
        return http.get(`/Collections/${id}`);
    }
}