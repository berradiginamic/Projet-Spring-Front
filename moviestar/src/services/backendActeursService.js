// src/services/backendActeursService.js
import axios from 'axios';
// eslint-disable-next-line
const BASE_URL = 'http://localhost:8080';  // Décommentez cette ligne

const handleError = (error) => {
    console.error('Error during API request:', error);

    if (error.response) {
        console.error('Response data:', error.response.data);
        console.error('Response status:', error.response.status);
        console.error('Response headers:', error.response.headers);
    } else if (error.request) {
        console.error('No response received. Request:', error.request);
    } else {
        console.error('Error setting up the request:', error.message);
    }

    throw error;
};
const backendActeursService = {
    getAllActeurs: () => axios.get(`${BASE_URL}/acteurs`).catch(handleError),
    getActeurById: (id) => axios.get(`${BASE_URL}/acteurs/${id}`).catch(handleError),
    createActeur: (acteur) => axios.post(`${BASE_URL}/acteurs`, acteur).catch(handleError),
    updateActeur: (id, acteur) => axios.put(`${BASE_URL}/acteurs/${id}`, acteur).catch(handleError),
    deleteActeurById: (id) => axios.delete(`${BASE_URL}/acteurs/${id}`).catch(handleError),
    getFilmsByActeurId: (id) => axios.get(`${BASE_URL}/acteurs/${id}/films`).catch(handleError),
    fetchActeurFilms: (id) => axios.get(`${BASE_URL}/acteurs/${id}/films`).catch(handleError),

    // Additional methods based on repository queries
    // Add more methods as needed for your specific requirements
};

export default backendActeursService;