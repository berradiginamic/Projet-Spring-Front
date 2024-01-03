// Realisateurs.js
import React, { useEffect, useState } from 'react';
import Pagination from '../components/Pagination'; // Import the Pagination component
import RealisateurItem from './Realisateurs/RealisateurItem';
import RealisateursList from './Realisateurs/RealisateursList';
import backendServiceRealisateurs from '../services/backendServiceRealisateurs';
import { debounce } from '../utils'; // Import the debounce function
import '../styles/styles.css'; // Import styles
import { FaCog, FaSearch } from 'react-icons/fa';

{/* ------- Déclarations des Fonctions ----------*/}
const Realisateurs = () => {
  const [state, setState] = useState({
    realisateurs: [],
    selectedRealisateur: { films: [] },
    selectedItemIndex: null,
    currentPage: 1,
    pageSize: 10,
  });

  useEffect(() => {
    const fetchRealisateurs = async () => {
      try {
        const realisateursData = await backendServiceRealisateurs.fetchRealisateurs(state.currentPage, state.pageSize);
        setState((prevState) => ({ ...prevState, realisateurs: realisateursData }));
      } catch (error) {
        // Handle error
      }
    };

    fetchRealisateurs();
  }, [state.currentPage, state.pageSize]);

  const handleRealisateurClick = async (realisateur, index) => {
    try {
      console.log('Clicked Realisateur:', realisateur);

      if (realisateur.idRealisateur !== undefined) {
        console.log('Realisateur ID:', realisateur.idRealisateur);

        const filmsData = await backendServiceRealisateurs.fetchRealisateurFilms(realisateur.idRealisateur);

        if (filmsData && Array.isArray(filmsData)) {
          setState((prevState) => ({ ...prevState, selectedRealisateur: { ...prevState.selectedRealisateur, films: filmsData }, selectedItemIndex: index }));
        } else {
          console.error('Invalid or missing films data.');
        }
      } else {
        console.error('Realisateur ID is undefined.');
      }
    } catch (error) {
      console.error('Error fetching films:', error);
      // Display a user-friendly error message to the user if needed
    }
  };

  return (
    <div className="realisateur-container">
      <RealisateursList
        realisateurs={state.realisateurs}
        selectedItemIndex={state.selectedItemIndex}
        handleRealisateurClick={handleRealisateurClick}
      />
      {/* Add other components or content */}
    </div>
  );
};

export default Realisateurs;