// Realisateurs.js
import React, { useEffect, useState } from 'react';
import backendServiceRealisateurs from '../services/backendServiceRealisateurs';

const Realisateurs = () => {
  const [realisateurs, setRealisateurs] = useState([]);
  const [selectedRealisateurId, setSelectedRealisateurId] = useState(null);
  const [realisateurFilms, setRealisateurFilms] = useState([]);

  useEffect(() => {
    const fetchRealisateurs = async () => {
      try {
        const realisateursData = await backendServiceRealisateurs.fetchRealisateurs();
        setRealisateurs(realisateursData);
      } catch (error) {
        // Handle error
      }
    };

    fetchRealisateurs();
  }, []);

  const handleRealisateurClick = async (realisateurId) => {
    try {
      setSelectedRealisateurId(realisateurId);
      const filmsData = await backendServiceRealisateurs.fetchRealisateurFilms(realisateurId);
      setRealisateurFilms(filmsData);
    } catch (error) {
      // Handle error
    }
  };

  return (
    <div>
      <h2>Realisateurs Page</h2>
      <ul>
        {realisateurs.map((realisateur) => (
          <li key={realisateur.id} onClick={() => handleRealisateurClick(realisateur.id)}>
            {realisateur.nom}
          </li>
        ))}
      </ul>

      {selectedRealisateurId && (
        <div>
          <h3>Films by Selected Realisateur</h3>
          <ul>
            {realisateurFilms.map((film) => (
              <li key={film.id}>{film.title}</li>
            ))}
          </ul>
        </div>
      )}
      {/* Add more content and functionality as needed */}
    </div>
  );
};

export default Realisateurs;