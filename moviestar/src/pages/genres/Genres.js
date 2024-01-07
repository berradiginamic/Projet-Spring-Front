import React, { useEffect, useState } from 'react';
import { FaTrash } from 'react-icons/fa';
import backendServiceGenres from '../../services/backendServiceGenres';
import backendServiceFilms from '../../services/backendServiceFilms';
import '../../styles/genres.css';

const Genres = () => {
  const [genres, setGenres] = useState([]);
  const [newGenreName, setNewGenreName] = useState('');
  const [updatedGenreName, setUpdatedGenreName] = useState('');
  // eslint-disable-next-line
  const [selectedGenreId, setSelectedGenreId] = useState(null);
  const [selectedGenreFilms, setSelectedGenreFilms] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedGenre, setSelectedGenre] = useState(null);

  useEffect(() => {
    const fetchGenres = async () => {
      try {
        const genresData = await backendServiceGenres.fetchGenres();
        setGenres(genresData);
      } catch (error) {
        console.error('Error fetching genres:', error);
      }
    };

    fetchGenres();
  }, []);

  const fetchFilmsByGenre = async (genreId) => {
    try {
      console.log('Fetching films for genreId:', genreId);
      const films = await backendServiceFilms.getFilmsByGenreId(genreId);
      console.log('Films:', films);

      // Assurez-vous que la structure des données est correcte
      console.log('Films Array:', films);  // Ajout de cette ligne pour voir la structure exacte

      setSelectedGenreFilms(films.map(filmArray => ({
        id: filmArray[0],  // Assurez-vous que l'index est correct
        title: filmArray[0],  // Utilisez l'index 0 pour obtenir le nom du film
        anneeSortie: filmArray[0],  // Utilisez l'index 1 pour obtenir l'année de sortie
      })));

      setSelectedGenre(genreId);
      setIsModalOpen(true);
    } catch (error) {
      console.error('Error fetching films by genre:', error);
    }
  };
// eslint-disable-next-line
  const renderSelectedGenreFilms = () => {
    return (
      <div>
        <h3>Films du genre sélectionné</h3>
        <ul>
          {selectedGenreFilms.map((film) => (
            <li key={film.id}>
              <strong>Nom:</strong> {film.title}, <strong>Date de sortie:</strong> {film.anneeSortie}
            </li>
          ))}
        </ul>
      </div>
    );
  };

  const handleAddGenre = async () => {
    try {
      const newGenre = await backendServiceGenres.addGenre(newGenreName);
      setGenres((prevGenres) => [...prevGenres, newGenre]);
      setNewGenreName('');
    } catch (error) {
      console.error('Error adding genre:', error);
    }
  };

  const handleUpdateGenre = async () => {
    if (selectedGenre !== null && updatedGenreName.trim() !== '') {
      try {
        const updatedGenre = await backendServiceGenres.updateGenre(selectedGenre, { name: updatedGenreName });
        setGenres((prevGenres) =>
          prevGenres.map((genre) => (genre.genreId === selectedGenre ? updatedGenre : genre))
        );
        setUpdatedGenreName('');
        setSelectedGenre(null);
      } catch (error) {
        console.error('Error updating genre:', error);
      }
    }
  };

  const handleDeleteGenre = async (genreId) => {
    try {
      await backendServiceGenres.deleteGenre(genreId);
      setGenres((prevGenres) => prevGenres.filter((genre) => genre.genreId !== genreId));
    } catch (error) {
      console.error('Error deleting genre:', error);
    }
  };

  return (
      <div>
        <h2>Genres des films et séries TV populaires</h2>
        <ul className="genre-list">
          {genres.map((genre, index) => (
            <li key={index} className={`genre-item${genre.genreId === 1 ? ' double-column' : ''}`}>
              <div>
                <button
                  onClick={() => {
                    console.log('Button clicked for genreId:', genre.genreId);
                    fetchFilmsByGenre(genre.genreId);
                  }}
                  style={{
                    backgroundImage: `url(/images/${(genre.type || 'default').toLowerCase()}.jpg)`,
                    backgroundSize: 'cover',
                  }}
                ></button>
                <span>{genre.type}</span>{' '}
                {/* Replace delete button with trash icon */}
                <FaTrash onClick={() => handleDeleteGenre(genre.genreId)} />
              </div>
            </li>
          ))}
        </ul>

      {isModalOpen && (
        <div className="modal">
          <button onClick={() => setIsModalOpen(false)}>Fermer la fenêtre modale</button>
          {selectedGenreFilms.length > 0 && (
            <div>
              <h3>Films du genre sélectionné</h3>
              <ul>
                {selectedGenreFilms.map((film) => (
                  <li key={film.id}>{film.title}>{film.anneeSortie}</li>
                ))}
              </ul>
            </div>
          )}
        </div>
      )}
      <div>
        <h3>Ajouter un nouveau genre</h3>
        <input type="text" value={newGenreName} onChange={(e) => setNewGenreName(e.target.value)} />
        <button onClick={handleAddGenre}>Ajouter le genre</button>
      </div>
      <div>
        <h3>Modifier le genre</h3>
        <input
          type="text"
          value={updatedGenreName}
          onChange={(e) => setUpdatedGenreName(e.target.value)}
        />
        <button onClick={handleUpdateGenre}>Mettre à jour le genre</button>
      </div>
    </div>
  );
};

export default Genres;