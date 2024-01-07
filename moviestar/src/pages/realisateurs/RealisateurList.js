// RealisateursList.js
import React, { useRef } from 'react';
import '../../styles/realisateurs.css';
import RealisateurItem from './RealisateurItem';

const RealisateursList = ({ realisateurs, handleRealisateurClick }) => {
    const realisateursListRef = useRef();

    return (
        <div className="realisateurs-list" ref={realisateursListRef}>
            <ul>
                {realisateurs.map((realisateur) => (
                    <li key={realisateur.id}>
                        <RealisateurItem
                            realisateur={realisateur}
                            onClick={() => handleRealisateurClick({ ...realisateur, id: realisateur.idRealisateur })}
                        />
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default RealisateursList;
