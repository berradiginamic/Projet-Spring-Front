// ModifyRealisateurModal.js
import React, { useState, useEffect } from 'react';
import '../../styles/ModifyRealisateurModal.css';

const ModifyRealisateurModal = ({ isOpen, handleClose, realisateur, onSave }) => {
    const [modifiedInfo, setModifiedInfo] = useState({
        nom: '',
        // Add other fields as needed
    });

    useEffect(() => {
        if (realisateur) {
            setModifiedInfo({
                nom: realisateur.nom || '',
                // Update with other fields as needed
            });
        }
    }, [realisateur]);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setModifiedInfo((prevInfo) => ({
            ...prevInfo,
            [name]: value,
        }));
    };

    const handleSave = () => {
        onSave(modifiedInfo);
        handleClose();
    };

    return (
        <div className={`modify-realisateur-modal ${isOpen ? 'open' : ''}`}>
            <div className="modal-content">
                <button className="modal-close" onClick={handleClose}>
                    Close
                </button>
                <h2>Modifier Réalisateur</h2>
                <form>
                    <label>
                        Nom:
                        <input
                            type="text"
                            name="nom"
                            value={modifiedInfo.nom}
                            onChange={handleInputChange}
                        />
                    </label>
                    {/* Add other input fields for modification */}
                </form>
                <button onClick={handleSave}>Enregistrer</button>
            </div>
        </div>
    );
};

export default ModifyRealisateurModal;