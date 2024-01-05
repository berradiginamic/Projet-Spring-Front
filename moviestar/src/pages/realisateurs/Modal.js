// Modal.js
import React from 'react';
import '../../styles/modal.css';

const Modal = ({ isOpen, handleClose, films }) => {
    if (!isOpen) return null;

    return (
        <div className="modal-overlay">
            <div className="modal-content">
                <button className="modal-close" onClick={handleClose}>
                    Close
                </button>
                <h2>Filmographie de {films.realisateurName}</h2>
                <ul>
                    {films.data.map((film, index) => (
                        <li key={index}>Films: {`${film[0] || 'Unknown'} - Année de Sortie: ${film[1] || 'Unknown'}`}</li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default Modal;