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
                {acteurs.map((actorData, index) => (
                    <li key={index}>
                        <strong>Nom de films:</strong> {actorData[0]}, <strong>Année de sortie:</strong>{actorData[1]}
                        {actorData.slice(1).map((film, filmIndex) => (
                            <span key={filmIndex}>{film[0]} ({film[1]}){filmIndex !== actorData.length - 2 ? ', ' : ''}</span>
                        ))}
                    </li>
                ))}
            </ul>
            {/* Ajout de fonctionnalité nécéssaire ici */}
            <h3> Filmographies: </h3>
        </div>
    );
};

export default Acteurs;