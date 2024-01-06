import React, { useState} from 'react';
import backendRechercheService from "../../services/backendRechercheService";

const ActeursCommuns2Films = ({ onUpdateModalResults }) => {
    const [filmId1, setFilmId1] = useState('');
    const [filmId2, setFilmId2] = useState('');
    const [acteurs, setActeurs] = useState([]);

    const handleActeursInFilmId1Change = (e) => {
        setFilmId1(e.target.value);
    };

    const handleActeursInFilmId2Change = (e) => {
        setFilmId2(e.target.value);
    };

    const handleFetchActeursInFilms = async () => {
        try {
            const response = await backendRechercheService.getActeursInFilms(filmId1, filmId2);
            const results = response.data.map(acteur => acteur[0]);
            onUpdateModalResults(results);
            setActeurs(response.data);
        } catch (error) {
            console.error('Error fetching acteurs:', error);
        }
    };

    return (
        <div>
            <h2>Acteurs Communs a 2 Films</h2>
            <label>
                Id Films 1:
                <input type="text" value={filmId1} onChange={handleActeursInFilmId1Change} />
            </label>
            <br />
            <label>
                Id Films 2:
                <input type="text" value={filmId2} onChange={handleActeursInFilmId2Change} />
            </label>
            <br />
            <button onClick={handleFetchActeursInFilms}>Valider</button>
            <ul>
                {acteurs.length > 0 ? (
                    acteurs.map((acteur, index) => (
                        <li key={index}>
                            <strong>Acteurs:</strong> {acteur[0]},
                        </li>
                    ))
                ) : (
                    <li>Renseigner un id valide</li>
                )}
            </ul>
        </div>
    );
};

export default ActeursCommuns2Films;