// RealisateurItem.js
import React from 'react';

const RealisateurItem = ({ realisateur, onClick, isSelected }) => (
  <li onClick={onClick} className={isSelected ? 'selected' : ''}>
    <strong>{realisateur.nom}</strong> <br />
    Date de naissance:{realisateur.dateNaissance} <br />
    Lieu de naissance: {realisateur.lieuNaissance} <br />
    Id IMDB: {realisateur.idIMDB}
  </li>
);

export default RealisateurItem;