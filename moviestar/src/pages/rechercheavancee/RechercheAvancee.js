import React, { useState } from 'react';
import ActeursCommuns2Films from './ActeursCommuns2Films';
import FilmsCommuns2Acteurs from './FilmsCommuns2Acteurs';
import FilmsEntre2Annees from "./FilmsEntre2Annees";
import FilmsEntre2Annees1Acteur from "./FilmsEntre2Annees1Acteur";
import Modal from './Modal';

// Modal component
const RechercheAvancee = () => {
    const [modalResults, setModalResults] = useState([]);
    const [modalTitle, setModalTitle] = useState('');
    const [isModalOpen, setIsModalOpen] = useState(false);

    const handleUpdateModalResults = (title, results) => {
        setModalTitle(title);
        setModalResults(results);
        setIsModalOpen(true);
    };

    const handleCloseModal = () => {
        setIsModalOpen(false);
    };

    return (
        <div>
            <h2>Recherche Avancée</h2>
            <ActeursCommuns2Films onUpdateModalResults={handleUpdateModalResults} />
            <FilmsCommuns2Acteurs onUpdateModalResults={handleUpdateModalResults} />
            <FilmsEntre2Annees onUpdateModalResults={handleUpdateModalResults} />
            <FilmsEntre2Annees1Acteur onUpdateModalResults={handleUpdateModalResults} />
            {/* Render or update the modal component */}
            {isModalOpen && (
                <Modal title={modalTitle} results={modalResults} onClose={handleCloseModal} />
            )}
        </div>
    );
};

export default RechercheAvancee;
