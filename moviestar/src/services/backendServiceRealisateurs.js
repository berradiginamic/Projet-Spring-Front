// backendServiceRealisateurs.js
const API_BASE_URL = 'http://localhost:8080';

const backendServiceRealisateurs = {
    fetchRealisateurs: async (page, pageSize) => {
        try {
            const response = await fetch(`${API_BASE_URL}/realisateurs?page=${page}&pageSize=${pageSize}`);
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

   searchRealisateurs: async (searchTerm) => {
     try {
       const response = await fetch(`${API_BASE_URL}/realisateurs/search?searchTerm=${searchTerm}`);
       if (!response.ok) {
         // Handle non-successful responses (e.g., 404 Not Found, 500 Internal Server Error)
         throw new Error(`HTTP error! Status: ${response.status}`);
       }

       const data = await response.json();
       return data;
     } catch (error) {
       console.error(`Error searching realisateurs for term "${searchTerm}":`, error);
       throw error;
     }
   },


};

export default backendServiceRealisateurs;