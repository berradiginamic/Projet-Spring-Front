// RealisateurItem.js
import React from 'react';

const RealisateurItem = ({ realisateur, onClick }) => {
    return (
        <div onClick={() => onClick(realisateur.idRealisateur)}>
            <strong>{realisateur.nom}</strong> <br />
            Date de naissance: {realisateur.dateNaissance} <br />
            Lieu de naissance: {realisateur.lieuNaissance} <br />
            Id IMDB: {realisateur.idIMDB}
        </div>
    );
};

export default RealisateurItem;