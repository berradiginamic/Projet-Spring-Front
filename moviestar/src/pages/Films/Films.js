import React, { useEffect, useState } from 'react';
import backendService from '../../backendServices/backendService';

const Films = () => {
    const [films, setFilms] = useState([]);

    useEffect(() => {
        const fetchFilms = async () => {
            try {
                const filmsData = await backendService.fetchFilms();
                setFilms(filmsData);
            } catch (error) {
                // Handle error
            }
        };

        fetchFilms();
    }, []);

    const handleFilmDetailsClick = async (filmId) => {
        try {
            const filmDetails = await backendService.fetchFilmDetails(filmId);
            console.log('Film Details:', filmDetails);
            // Handle displaying film details in the UI
        } catch (error) {
            // Handle error
        }
    };

    return (
        <div>
            <h2>Page Films</h2>
            <ul>
                {films.map((film) => (
                    <li key={film.id}>
                        {film.nom} - <button onClick={() => handleFilmDetailsClick(film.id)}>Details</button>
                    </li>
                ))}
            </ul>
            {/* Add more content and functionality as needed */}
        </div>
    );
};

export default Films;