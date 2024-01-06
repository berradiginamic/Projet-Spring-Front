// backendService.js
import axios from 'axios';

// No need for API_BASE_URL when using the proxy

const backendService = {
    // Fonction pour récupérer liste d'acteurs
    fetchActeurs: async () => {
        try {
            const response = await axios.get('/acteurs/250/films');
            return response.data;
        } catch (error) {
            console.error('Error fetching actors:', error);
            throw error;
        }
    },

    // Fonction pour récupérer liste de films
    fetchFilms: async () => {
        try {
            const response = await axios.get('/films');
            return response.data;
        } catch (error) {
            console.error('Error fetching films:', error);
            throw error;
        }
    },

    // Fonction pour récupérer détails d'un film
    fetchFilmDetails: async (filmId) => {
        try {
            const response = await axios.get(`/films/${filmId}`);
            return response.data;
        } catch (error) {
            console.error(`Error fetching film details for ID ${filmId}:`, error);
            throw error;
        }
    },
};

export default backendService;
