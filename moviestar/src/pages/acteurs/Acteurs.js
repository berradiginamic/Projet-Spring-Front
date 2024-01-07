// Acteurs.js
import React, { useEffect, useState } from 'react';
import backendService from '../../services/backendService';

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
                                <strong>Nom:</strong> {actorData.nom}, <strong>Lieu de Naissance:</strong>{actorData.lieu_naissance}
                            </li>
                        ))}
            </ul>
            {/* Ajout de fonctionnalité nécéssaire ici */}
            <h3> Filmographies: </h3>
        </div>
    );
};

export default Acteurs;