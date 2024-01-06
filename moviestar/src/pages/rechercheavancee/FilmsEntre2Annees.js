// src/pages/FilmsEntre2Annees.js
import React, { useState } from 'react';
import backendRechercheService from "../../services/backendRechercheService";

const FilmsEntre2Annees = ({ onUpdateModalResults }) => {
    const [startYear, setStartYear] = useState('');
    const [endYear, setEndYear] = useState('');
    const [films, setFilms] = useState([]);

    const handleBetweenYearsStartYearChange = (e) => {
        setStartYear(e.target.value);
    };

    const handleBetweenYearsEndYearChange = (e) => {
        setEndYear(e.target.value);
    };

    const handleFetchFilmsBetweenYears = async () => {
        try {
            const response = await backendRechercheService.getFilmsReleasedBetweenYears(startYear, endYear);
            const results = response.data.map(film => `${film.nom} (${film.anneeSortie})`);
            onUpdateModalResults(results);
            setFilms(response.data);
        } catch (error) {
            console.error('Error fetching films:', error);
        }
    };

    return (
        <div>
            <h2>Films entre 2 Années</h2>
            <label>
                Start Year:
                <input type="text" value={startYear} onChange={handleBetweenYearsStartYearChange} />
            </label>
            <br />
            <label>
                End Year:
                <input type="text" value={endYear} onChange={handleBetweenYearsEndYearChange} />
            </label>
            <br />
            <button onClick={handleFetchFilmsBetweenYears}>Fetch Films</button>
            <ul>
                {films.map((film, index) => (
                    <li key={index}>{film.nom} ({film.anneeSortie})</li>
                ))}
            </ul>
        </div>
    );
};

export default FilmsEntre2Annees;