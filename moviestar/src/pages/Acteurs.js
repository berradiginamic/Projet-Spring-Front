// Acteurs.js
import React, { useEffect, useState } from 'react';
import backendService from '../services/backendService';
import '../styles/styles.css';

const Acteurs = () => {
  const [acteurs, setActeurs] = useState([]);

  useEffect(() => {
    const fetchActeurs = async () => {
      try {
        const acteursData = await backendService.fetchActeurs();
        setActeurs(acteursData);
      } catch (error) {
        // Handle error
      }
    };

    fetchActeurs();
  }, []);


  return (
    <div className="component-container">
          <h2 className="component-heading">Page Acteur</h2>
          <ul className="list-container">
        {acteurs.map((acteur) => (
            <li key={acteur.id}>{acteur.nom}</li>
        ))}
      </ul>
      {/* Ajout de fonctionnalité nécéssaire ici */}
      Ello
    </div>
  );
};

export default Acteurs;