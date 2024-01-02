// backendService.js
const API_BASE_URL = 'http://localhost:8080';

const backendServiceRealisateurs = {

  fetchRealisateurs: async () => {
    try {
      const response = await fetch(`${API_BASE_URL}/realisateurs`);
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error fetching realisateurs:', error);
      throw error;
    }
  },

  fetchRealisateurFilms: async (realisateurId) => {
    try {
      const response = await fetch(`${API_BASE_URL}/realisateurs/${realisateurId}/films`);
      const data = await response.json();
      return data;
    } catch (error) {
      console.error(`Error fetching films for realisateur with ID ${realisateurId}:`, error);
      throw error;
    }
  },
};

export default backendServiceRealisateurs;