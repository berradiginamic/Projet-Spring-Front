import React, { useEffect, useState } from 'react';
import RealisateursTitle from './RealisateursTitle';
import SearchBar from '../../components/SearchBar';
import RealisateurList from './RealisateurList';
import ModifyRealisateurModal from './ModifyRealisateurModal';
import backendRealisateurService from '../../services/backendRealisateursService';
import Modal from './Modal';

const Realisateurs = () => {
    const [realisateurs, setRealisateurs] = useState([]);
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
        console.log('Clicked Realisateur:', realisateur);
        try {
            console.log('Clicked Realisateur:', realisateur);
            console.log('Selected Realisateur:', selectedRealisateur);

            if (realisateur.id !== undefined) {
                console.log('Realisateur ID:', realisateur.id);

                setSelectedRealisateur(realisateur); // Set selectedRealisateur first

                const filmsData = await backendRealisateurService.fetchRealisateurFilms(
                    realisateur.id
                );

                console.log('Films Data:', filmsData);

                if (Array.isArray(filmsData.data)) {
                    setModalFilms({
                        data: filmsData.data,
                        realisateurName: realisateur.nom,
                    });

                    setModalOpen(true);
                    setModifyModalOpen(true); // Open the modification modal on realisateur click
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

    const handleSaveModifiedRealisateur = async (modifiedInfo) => {
        try {
            console.log('Trying to save Modified Realisateur Info:', modifiedInfo);

            // Ensure selectedRealisateur is defined before making the update request
            if (selectedRealisateur) {
                // Send a request to update the realisateur in the backend
                await backendRealisateurService.updateRealisateur(
                    selectedRealisateur.idRealisateur,
                    modifiedInfo
                );

                // Update the state with the modified realisateur
                setRealisateurs((prevRealisateurs) =>
                    prevRealisateurs.map((r) =>
                        r && r.id === selectedRealisateur.id ? { ...r, ...modifiedInfo } : r
                    )
                );

                setModifyModalOpen(false);
                setSelectedRealisateur(null); // Reset selected realisateur after modification
            } else {
                console.error('Selected realisateur is undefined.');
            }
        } catch (error) {
            console.error('Error updating realisateur:', error);
            // Handle error as needed (e.g., show an error message to the user)
        }
    };

    return (
        <div>
            <RealisateursTitle />
            <SearchBar onSearch={handleSearch} />
            <button onClick={() => setModifyModalOpen(true)}>
                Modifier Réalisateurs
            </button>
            <RealisateurList
                realisateurs={filteredRealisateurs}
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
