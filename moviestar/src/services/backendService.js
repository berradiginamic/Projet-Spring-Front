// backendService.js
const API_BASE_URL = 'http://localhost:8080'; // Replace with your backend URL

const backendService = {
  // Définition de fonctions pour intéragir avec le backend
  // Fonction pour récupérer liste d'acteurs
  fetchActeurs: async () => {
      try {
        const response = await fetch(`http://localhost:8080/acteurs/250/films`);  // A remplacer une fois le bug corriger
        const data = await response.json();
        return data;
      } catch (error) {
        console.error('Error fetching actors:', error);
        throw error;
      }
    },

  // Fonction pour récupérer liste de films
  fetchFilms: async () => {
      try {
        const response = await fetch(`${API_BASE_URL}/films`);
        const data = await response.json();
        return data;
      } catch (error) {
        console.error('Error fetching films:', error);
        throw error;
      }
    },

  // Fonction pour récupérer détails d'un film
  fetchFilmDetails: async (filmId) => {
      try {
        const response = await fetch(`${API_BASE_URL}/films/${filmId}`);
        const data = await response.json();
        return data;
      } catch (error) {
        console.error(`Error fetching film details for ID ${filmId}:`, error);
        throw error;
      }
    },
};

export default backendService;