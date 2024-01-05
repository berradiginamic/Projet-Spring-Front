// src/pages/Realisateurs.js
import React, { useEffect, useState } from 'react';
import RealisateursTitle from './RealisateursTitle';
import SearchBar from '../../components/SearchBar';
import RealisateursList from "./RealisateurList";
import ModifyRealisateurModal from './ModifyRealisateurModal';
import backendRealisateurService from "../../services/backendRealisateursService";
import Modal from './Modal'; // Import Modal component

const Realisateurs = () => {
    const [realisateurs, setRealisateurs] = useState([]);
    const [selectedItemIndex, setSelectedItemIndex] = useState(null);
    const [filteredRealisateurs, setFilteredRealisateurs] = useState([]);
    const [isModalOpen, setModalOpen] = useState(false);
    const [modalFilms, setModalFilms] = useState({ data: [], realisateurName: '' });
    const [modifyModalOpen, setModifyModalOpen] = useState(false);
    const [selectedRealisateur, setSelectedRealisateur] = useState(null);

    useEffect(() => {
        backendRealisateurService.getAllRealisateurs().then((response) => {
            setRealisateurs(response.data);
            setFilteredRealisateurs(response.data);
        });
    }, []);

    const handleSearch = (searchTerm) => {
        const filteredList = realisateurs.filter((realisateur) =>
            realisateur.nom.toLowerCase().includes(searchTerm.toLowerCase())
        );
        setFilteredRealisateurs(filteredList);
    };

    const handleRealisateurClick = async (realisateur) => {
        try {
            console.log('Clicked Realisateur:', realisateur);

            if (realisateur.idRealisateur !== undefined) {
                console.log('Realisateur ID:', realisateur.idRealisateur);

                const filmsData = await backendRealisateurService.fetchRealisateurFilms(
                    realisateur.idRealisateur
                );

                console.log('Films Data:', filmsData);

                if (Array.isArray(filmsData.data)) {
                    setModalFilms({
                        data: filmsData.data,
                        realisateurName: realisateur.nom,
                    });

                    setModalOpen(true);
                    setSelectedRealisateur(realisateur);
                } else {
                    console.error('Invalid or missing films data:', filmsData);
                }
            } else {
                console.error('Realisateur ID is undefined.');
            }
        } catch (error) {
            console.error('Error fetching films:', error);
        }
    };

    const handleModalClose = () => {
        setModalOpen(false);
        setModalFilms({ data: [], realisateurName: '' });
    };

    const handleModifyRealisateur = (realisateur) => {
        setSelectedRealisateur(realisateur);
        setModifyModalOpen(true);
    };

    const handleSaveModifiedRealisateur = (modifiedInfo) => {
        console.log('Trying to save Modified Realisateur Info:', modifiedInfo);

        setRealisateurs((prevRealisateurs) =>
            prevRealisateurs.map((r) =>
                r && r.id === selectedRealisateur.id ? { ...r, ...modifiedInfo } : r
            )
        );

        setModifyModalOpen(false);
        setSelectedRealisateur(null); // Reset selected realisateur after modification
    };

    return (
        <div>
            <RealisateursTitle />
            <SearchBar onSearch={handleSearch} />
            <button onClick={handleModifyRealisateur}>
                Modifier Réalisateurs
            </button>
            <RealisateursList
                realisateurs={filteredRealisateurs}
                selectedItemIndex={selectedItemIndex}
                handleRealisateurClick={handleRealisateurClick}
            />

            {/* Add Modal component */}
            <Modal isOpen={isModalOpen} handleClose={handleModalClose} films={modalFilms} />
            {/* Add ModifyRealisateurModal */}
            <ModifyRealisateurModal
                isOpen={modifyModalOpen}
                handleClose={() => setModifyModalOpen(false)}
                realisateur={selectedRealisateur}
                onSave={handleSaveModifiedRealisateur}
            />
        </div>
    );
};

export default Realisateurs;
