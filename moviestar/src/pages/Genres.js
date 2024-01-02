// Genres.js
import React, { useEffect, useState } from 'react';
import backendServiceGenres from '../services/backendServiceGenres';

const Genres = () => {
  const [genres, setGenres] = useState([]);
  const [newGenreName, setNewGenreName] = useState('');
  const [updatedGenreName, setUpdatedGenreName] = useState('');
  const [selectedGenreId, setSelectedGenreId] = useState(null);

  useEffect(() => {
    const fetchGenres = async () => {
      try {
        const genresData = await backendServiceGenres.fetchGenres();
        setGenres(genresData);
      } catch (error) {
        // Handle error
      }
    };

    fetchGenres();
  }, []);

  const handleAddGenre = async () => {
    try {
      const newGenre = await backendServiceGenres.addGenre(newGenreName);
      setGenres((prevGenres) => [...prevGenres, newGenre]);
      setNewGenreName('');
    } catch (error) {
      // Handle error
    }
  };

  const handleUpdateGenre = async () => {
    if (selectedGenreId && updatedGenreName.trim() !== '') {
      try {
        const updatedGenre = await backendServiceGenres.updateGenre(selectedGenreId, { name: updatedGenreName });
        setGenres((prevGenres) =>
          prevGenres.map((genre) => (genre.id === selectedGenreId ? updatedGenre : genre))
        );
        setUpdatedGenreName('');
        setSelectedGenreId(null);
      } catch (error) {
        // Handle error
      }
    }
  };

  const handleDeleteGenre = async (genreId) => {
    try {
      await backendServiceGenres.deleteGenre(genreId);
      setGenres((prevGenres) => prevGenres.filter((genre) => genre.id !== genreId));
    } catch (error) {
      // Handle error
    }
  };

  return (
    <div>
      <h2>Page Genres</h2>
      <ul>
        {genres.map((genre) => (
          <li key={genre.id}>
            {genre.name} -{' '}
            <button onClick={() => setSelectedGenreId(genre.id)}>Edit</button>{' '}
            <button onClick={() => handleDeleteGenre(genre.id)}>Delete</button>
          </li>
        ))}
      </ul>

      <div>
        <h3>Add New Genre</h3>
        <input
          type="text"
          value={newGenreName}
          onChange={(e) => setNewGenreName(e.target.value)}
        />
        <button onClick={handleAddGenre}>Add Genre</button>
      </div>

      <div>
        <h3>Edit Genre</h3>
        <input
          type="text"
          value={updatedGenreName}
          onChange={(e) => setUpdatedGenreName(e.target.value)}
        />
        <button onClick={handleUpdateGenre}>Update Genre</button>
      </div>
      {/* Add more content and functionality as needed */}
    </div>
  );
};

export default Genres;