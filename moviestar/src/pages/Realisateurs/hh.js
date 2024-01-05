// Realisateurs.js
import React, { useEffect, useState } from 'react';
import Pagination from '../../components/Pagination'; // Import the Pagination component
import RealisateurItem from './RealisateurItem';
import backendServiceRealisateurs from '../../backendServices/backendServiceRealisateurs';
import { debounce } from '../../utils'; // Import the debounce function
import '../../styles/styles.css'; // Import styles
import { FaCog, FaSearch } from 'react-icons/fa';

const Realisateurs = () => {
  const [realisateurs, setRealisateurs] = useState([]);
  const [selectedRealisateur, setSelectedRealisateur] = useState({ films: [] });
  const [currentPage, setCurrentPage] = useState(1);
  const pageSize = 10; // Number of realisateurs per page
  const [selectedItemIndex, setSelectedItemIndex] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  // State variables for search-related pagination
  const [searchPage, setSearchPage] = useState(1);
  const searchPageSize = 10;

  useEffect(() => {
    const fetchRealisateurs = async () => {
      try {
        const response = await backendServiceRealisateurs.fetchRealisateurs(currentPage, pageSize);
        const realisateursData = response?.content; // Use optional chaining to handle null or undefined

        if (realisateursData) {
          setRealisateurs(realisateursData);
        } else {
          // Handle the case where realisateursData is undefined or null
          console.error('Realisateurs data is undefined or null.');
        }
      } catch (error) {
        // Handle error
      }
    };

    fetchRealisateurs();
  }, [currentPage, pageSize]);

  const handleRealisateurClick = async (realisateur, index) => {
    try {
      console.log('Clicked Realisateur:', realisateur);

      // Check if realisateur.idRealisateur is defined
      if (realisateur.idRealisateur !== undefined) {
        console.log('Realisateur ID:', realisateur.idRealisateur); // Log the realisateur ID
        setSelectedRealisateur(realisateur);

        const filmsData = await backendServiceRealisateurs.fetchRealisateurFilms(realisateur.idRealisateur);
        console.log('Films Data:', filmsData); // Log the films data

        // Assuming filmsData is an array of film objects
        setSelectedRealisateur((prevRealisateur) => ({ ...prevRealisateur, films: filmsData }));
        setSelectedItemIndex(index); // Set the selected item index
      } else {
        console.error('Realisateur ID is undefined.');
      }
    } catch (error) {
      console.error('Error fetching films:', error);
    }
  };

  // Fonction de la barre de recherche
  const handleSearchInputChange = (event) => {
    const searchTerm = event.target.value;
    setSearchTerm(searchTerm);
  };

  const debouncedSearch = debounce(async () => {
    try {
      const realisateursData = await backendServiceRealisateurs.searchRealisateurs(searchTerm);

      // Ensure that realisateursData is an array before updating the state
      if (Array.isArray(realisateursData)) {
        setRealisateurs(realisateursData);
      } else {
        // If no search results, set the state to an empty array
        setRealisateurs([]);
      }
    } catch (error) {
      console.error('Error fetching realisateurs:', error);
    }
  }, 300);

  useEffect(() => {
    debouncedSearch();
  }, [searchTerm, debouncedSearch]);

  const handleModifyRealisateurClick = async () => {
    try {
      // You can implement the modification logic here
      // For example, you can open a modal or navigate to a modification page
      console.log('Modify Realisateur clicked for ID:', selectedRealisateur.idRealisateur);
    } catch (error) {
      console.error('Error modifying realisateur:', error);
    }
  };

  // Additional logs to inspect the state and films data
  useEffect(() => {
    console.log('Selected Realisateur State:', selectedRealisateur);
  }, [selectedRealisateur]);

  return (
      <div className="container">
        <div className="realisateurs-list">
          <h2>Liste de Réalisateurs</h2>
          {console.log('Realisateurs State:', realisateurs)}
          <ul>
            {realisateurs.map((realisateur, index) => (
                <RealisateurItem
                    key={realisateur.id}
                    realisateur={realisateur}
                    onClick={() => handleRealisateurClick(realisateur, index)}
                    isSelected={index === selectedItemIndex}
                />
            ))}
          </ul>
          {/* Pagination controls */}
          <Pagination
              currentPage={currentPage}
              totalPages={Math.ceil(realisateurs.length / pageSize)}
              onPreviousPage={() => setCurrentPage(currentPage - 1)}
              onNextPage={() => setCurrentPage(currentPage + 1)}
          />
        </div>

        {/* Search Bar Container */}
        <div className="search-bar-container">
          <div className="search-bar">
            <input
                type="text"
                placeholder="Rechercher un réalisateur"
                value={searchTerm}
                onChange={handleSearchInputChange}
            />
            <FaSearch />
          </div>
        </div>

        {/* Boite de filmographie */}
        {selectedRealisateur.films && selectedRealisateur.films.length > 0 && (
            <div className="films-section">
              <h3>Filmographie</h3>
              <p>Chefs d'Oeuvre de {selectedRealisateur.nom} :</p>
              <ul>
                {selectedRealisateur.films.map((film) => (
                    <li key={film.id}>{film.nom}</li>
                ))}
              </ul>
            </div>
        )}

        {/* Add these additional logs */}
        <div>
          <h3>Rendering Information</h3>
          <p>Selected Realisateur ID: {selectedRealisateur.idRealisateur}</p>
          <p>Films Array: {JSON.stringify(selectedRealisateur.films)}</p>
        </div>

        {/* Add the "Modifier Réalisateur" section */}
        <div className="modify-realisateur-section" onClick={() => handleModifyRealisateurClick()}>
          <span>Modifier Réalisateur</span>
          <FaCog style={{ color: 'red' }} /> {/* React Font Awesome icon */}
        </div>

      </div>
  );
};

export default Realisateurs;