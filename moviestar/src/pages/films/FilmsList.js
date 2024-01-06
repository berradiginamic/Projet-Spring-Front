import React from 'react';

const FilmsList = ({  films }) => (
    <ul>
        {films.map((film) => (
            <li key={film.filmId}>{film.nom}</li>
        ))}
    </ul>
);

export default FilmsList;
