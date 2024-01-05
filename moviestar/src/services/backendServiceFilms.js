// backendServiceFilms.js
import axios from 'axios';
 // eslint-disable-next-line
const BASE_URL = 'http://localhost:8080'; // Remplacez cela par l'URL réelle de votre backend

const backendServiceFilms = {
   getFilmsByGenreId: async (genreId) => {
      try {
        const response = await axios.get(`http://localhost:8080/films/by-genre?genreId=${genreId}`);
        return response.data;
      } catch (error) {
        throw error;
      }
    },
  };

export default backendServiceFilms;