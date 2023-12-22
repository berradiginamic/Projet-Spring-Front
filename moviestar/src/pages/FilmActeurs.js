// src/pages/MoviesByActor.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const MoviesByActor = () => {
  const [actorId, setActorId] = useState('');
  const [movies, setMovies] = useState([]);

  const handleActorIdChange = (e) => {
    setActorId(e.target.value);
  };

  const handleFetchMovies = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/acteurs/${actorId}/movies`);
      setMovies(response.data);
    } catch (error) {
      console.error('Error fetching movies:', error);
    }
  };

  return (
    <div>
      <h2>Movies by Actor</h2>
      <label>
        Actor ID:
        <input type="text" value={actorId} onChange={handleActorIdChange} />
      </label>
      <br />
      <button onClick={handleFetchMovies}>Fetch Movies</button>
      <ul>
        {movies.map((movie, index) => (
          <li key={index}>{movie.titre} ({movie.annee})</li>
        ))}
      </ul>
    </div>
  );
};

export default MoviesByActor;