// RealisateursList.js
import React, { useEffect, useRef } from 'react';
import RealisateurItem from './RealisateurItem';
import './realisateurs.css';

const RealisateursList = ({ realisateurs, selectedItemIndex, handleRealisateurClick, state }) => {
  console.log('Rendering RealisateursList...');
  console.log('Realisateurs:', realisateurs);
    console.log('Selected Item Index:', selectedItemIndex);
    console.log('State:', state);
  const realisateursListRef = useRef();

  useEffect(() => {
    const handleClickOutside = (event) => {
      if (realisateursListRef.current && !realisateursListRef.current.contains(event.target)) {
        // Clicked outside the realisateurs list
        const selectedRealisateur = state.selectedRealisateur;
        const selectedItemIndex = state.selectedItemIndex;

        if (selectedRealisateur !== null && selectedItemIndex !== null) {
          // Deselect réalisateur only if it was previously selected
          const realisateur = realisateurs[selectedItemIndex];
          handleRealisateurClick(realisateur, null);
        }
      }
    };

    document.addEventListener('click', handleClickOutside);

    return () => {
      document.removeEventListener('click', handleClickOutside);
    };
  }, [state, handleRealisateurClick]);

  if (realisateurs.length === 0) {
      return <p>No réalisateurs available</p>;
    }


  return (
      <div className="realisateurs-list" ref={realisateursListRef}>
        <h2>Liste de Réalisateurs</h2>
        {realisateurs.length > 0 ? ( // Check if realisateurs array is not empty
          <ul>
            {realisateurs.map((realisateur, index) => (
              <li key={realisateur.id}>
                <RealisateurItem
                  realisateur={realisateur}
                  onClick={() => handleRealisateurClick(realisateur, index)}
                  isSelected={index === selectedItemIndex}
                />
              </li>
            ))}
          </ul>
        ) : (
          <p>No réalisateurs available</p>
        )}
      </div>
    );
  };

  export default RealisateursList;
