import React, { useState, useEffect } from 'react';
import RealisateursList from './Realisateurs/RealisateursList';
import Pagination from '../components/Pagination';
import './Realisateurs/realisateurs.css';
import backendServiceRealisateurs from '../services/backendServiceRealisateurs';

const Realisateurs = () => {
  const [state, setState] = useState({
    realisateurs: [],  // Make sure realisateurs is initialized as an empty array
    selectedRealisateur: { films: [] },
    selectedItemIndex: null,
    currentPage: 1,
    pageSize: 10,
    totalPages: 1,
  });

  useEffect(() => {
    const fetchRealisateurs = async () => {
      try {
        const realisateursData = await backendServiceRealisateurs.fetchRealisateurs(
          state.currentPage,
          state.pageSize
        );

        // Log the realisateursData to the console
        console.log('Realisateurs data:', realisateursData);


        setState((prevState) => ({
          ...prevState,
          realisateurs: realisateursData.content || [], // Ensure realisateurs is not undefined
          totalPages: realisateursData.totalPages,
        }));
      } catch (error) {
        console.error('Error fetching réalisateur data:', error);
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

            const filmsData = await backendServiceRealisateurs.fetchRealisateurFilms(
              realisateur.idRealisateur
            );

            if (filmsData && Array.isArray(filmsData)) {
              setState((prevState) => ({
                ...prevState,
                selectedRealisateur: { ...prevState.selectedRealisateur, films: filmsData },
                selectedItemIndex: index,
              }));
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

  const handlePageChange = (newPage) => {
      setState((prevState) => ({ ...prevState, currentPage: newPage }));
    };

    return (
        <div className="realisateur-container">
          <RealisateursList
            realisateurs={state.realisateurs}
            selectedItemIndex={state.selectedItemIndex}
            handleRealisateurClick={handleRealisateurClick}
            state={state}
          />
          <Pagination
            currentPage={state.currentPage}
            totalPages={state.totalPages}
            onPageChange={handlePageChange} // Pass the handlePageChange function
            onPreviousPage={() => handlePageChange(state.currentPage - 1)}
            onNextPage={() => handlePageChange(state.currentPage + 1)}
          />
        </div>
      );
};

export default Realisateurs;
