// src/pages/FilmsEntre2Annees.js
import React, { useState} from 'react';
import backendRechercheService from "../../services/backendRechercheService";

const FilmsCommuns2Acteurs = ({ onUpdateModalResults }) => {
    const [acteurId1, setActeurId1] = useState('')
    const [acteurId2, setActeurId2] = useState('')
    const [films, setFilms] = useState([]);

    const handleFilmsByTwoActeurId1Change = (e) => {
        setActeurId1(e.target.value);
    };

    const handleFilmsByTwoActeurId2Change = (e) => {
        setActeurId2(e.target.value);
    };

    const handleFetchFilmsByTwoActors = async () => {
        try {
            const response = await backendRechercheService.getFilmsByTwoActors(acteurId1, acteurId2);
            const results = response.data.map(film => `${film[0]} (${film[1]})`);
            onUpdateModalResults(results);
            setFilms(response.data); // Update the films state as well
        } catch (error) {
            console.error('Error fetching films:', error);
        }
    };

    return (
        <div>
            <h2>Films Communs A 2 Acteurs</h2>
            <label>
                Id Premier Acteurs:
                <input type="text" value={acteurId1} onChange={handleFilmsByTwoActeurId1Change}/>
            </label>
            <br/>
            <label>
                Id Deuxieme Acteurs:
                <input type="text" value={acteurId2} onChange={handleFilmsByTwoActeurId2Change}/>
            </label>
            <br/>
            <button onClick={handleFetchFilmsByTwoActors}>Fetch Films</button>
            <ul>
                {films.length > 0 ? (
                    films.map((film, index) => (
                        <li key={index}>
                            <strong>Nom de Films:</strong> {film[0]},
                            <strong> Année de Sortie:</strong> {film[1]}
                        </li>
                    ))
                ) : (
                    <li>No films found</li>
                )}
            </ul>
        </div>
    );
};

export default FilmsCommuns2Acteurs;