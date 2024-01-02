// backendServiceGenres.js
const API_BASE_URL = 'http://localhost:8080'; // Replace with your backend URL

const backendServiceGenres = {

// Fonction pour recuperer la liste des genres
fetchGenres: async () => {
    try {
      const response = await fetch(`${API_BASE_URL}/genres`);
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error fetching genres:', error);
      throw error;
    }
  },

// Fonction pour ajouter un genre
  addGenre: async (genreName) => {
    try {
      const response = await fetch(`${API_BASE_URL}/genres`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name: genreName }),
      });

      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error adding genre:', error);
      throw error;
    }
  },

// Fonction pour modifier un genre
  updateGenre: async (genreId, updatedGenre) => {
    try {
      const response = await fetch(`${API_BASE_URL}/genres/${genreId}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedGenre),
      });

      const data = await response.json();
      return data;
    } catch (error) {
      console.error(`Error updating genre with ID ${genreId}:`, error);
      throw error;
    }
  },

// Fonction pour supprimer un genre
  deleteGenre: async (genreId) => {
    try {
      const response = await fetch(`${API_BASE_URL}/genres/${genreId}`, {
        method: 'DELETE',
      });

      const data = await response.json();
      return data;
    } catch (error) {
      console.error(`Error deleting genre with ID ${genreId}:`, error);
      throw error;
    }
  },
};

export default backendServiceGenres;