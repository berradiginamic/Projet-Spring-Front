// FilmInfo.js
import React from 'react';

const FilmInfo = ({ selectedRealisateur }) => {
    return (
        <div className="film-info">
            {selectedRealisateur && (
                <>
                    <h2>Filmographie de {selectedRealisateur.nom}</h2>
                    {selectedRealisateur.films ? (
                        <ul>
                            {selectedRealisateur.films.map((film, index) => (
                                <li key={index}>
                                    Films: {`${film[0] || 'Unknown'} - Année de Sortie: ${film[1] || 'Unknown'}`}
                                </li>
                            ))}
                        </ul>
                    ) : (
                        <p>Pas de Films Disponibles</p>
                    )}
                </>
            )}
        </div>
    );
};

export default FilmInfo;
