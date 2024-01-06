// src/pages/FilmsEntre2Annees.js
import React, { useState } from 'react';
import backendRechercheService from "../../services/backendRechercheService";

const FilmsEntre2Annees1Acteur = ({ onUpdateModalResults }) => {
    const [startYear, setStartYear] = useState('');
    const [endYear, setEndYear] = useState('');
    const [acteurId, setActeurId] = useState('')
    const [films, setFilms] = useState([]);

    const handleYearsAndByActeurStartYearChange = (e) => {
        setStartYear(e.target.value);
    };

    const handleYearsAndByActeurEndYearChange = (e) => {
        setEndYear(e.target.value);
    };

    const handleYearsAndByActeurIdChange = (e) => {
        setActeurId(e.target.value);
    };

    const handleFetchFilmsBetweenYearsAndByActeur = async () => {
        try {
            // Check if acteurId is a valid number
            if (!isNaN(acteurId)) {
                const response = await backendRechercheService.getFilmsReleasedBetweenYearsAndByActeur(startYear, endYear, acteurId);
                const results = response.data.map(film => `${film.nom} (${film.anneeSortie})`);
                onUpdateModalResults(results);
                setFilms(response.data);
            } else {
                console.error('Invalid acteurId:', acteurId);
            }
        } catch (error) {
            console.error('Error fetching films:', error);
        }
    };

    return (
        <div>
            <h2>Films Entre 2 Années Avec 1 Acteurs Communs</h2>
            <label>
                Start Year:
                <input type="text" value={startYear} onChange={handleYearsAndByActeurStartYearChange}/>
            </label>
            <br/>
            <label>
                End Year:
                <input type="text" value={endYear} onChange={handleYearsAndByActeurEndYearChange}/>
            </label>
            <label>
                Acteur Id:
                <input type="text" value={acteurId} onChange={handleYearsAndByActeurIdChange}/>
            </label>
            <br/>
            <button onClick={handleFetchFilmsBetweenYearsAndByActeur}>Fetch Films</button>
            <ul>
                {films.length > 0 ? (
                    films.map((film, index) => (
                        <li key={index}>
                            <strong>Nom de Films:</strong> {film[0]},
                            <strong> Année de Sortie:</strong> {film[1]}
                        </li>
                    ))
                ) : (
                    <li>Renseigner un Id</li>
                )}
            </ul>
        </div>
    );
};

export default FilmsEntre2Annees1Acteur;