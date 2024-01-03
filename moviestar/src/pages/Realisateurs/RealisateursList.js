// RealisateursList.js
import React from 'react';
import RealisateurItem from './RealisateurItem';
import './realisateurs.css'; // Import the CSS file

const RealisateursList = ({ realisateurs, selectedItemIndex, handleRealisateurClick }) => {
  return (
    <div className="realisateurs-list">
      <h2>Liste de Réalisateurs</h2>
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
    </div>
  );
};

export default RealisateursList;