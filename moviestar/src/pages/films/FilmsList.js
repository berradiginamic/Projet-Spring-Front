import React, { useRef } from 'react';
import '../../styles/realisateurs.css'; // Adjust the import path if needed
import FilmsItem from './FilmsItem'; // Import the FilmItem component

const FilmsList = ({ films, handleFilmClick }) => {
    const filmsListRef = useRef();

    return (
        <div className="realisateurs-list" ref={filmsListRef}>
            <ul>
                {films.map((film) => (
                    <li key={film.id}>
                        <FilmsItem
                            film={film}
                            onClick={() => handleFilmClick(film)}
                        />
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default FilmsList;