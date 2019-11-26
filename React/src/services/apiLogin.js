import axios from 'axios';

const apiLogin = axios.create({
    baseURL: "http://localhost:8082"
});

export default apiLogin;