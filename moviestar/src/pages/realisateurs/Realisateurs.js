import React, { useEffect, useState } from 'react';
import RealisateursTitle from './RealisateursTitle';
import RealisateursSearchBar from './RealisateursSearchBar';
import RealisateurList from './RealisateurList';
import ModifyRealisateurModal from './ModifyRealisateurModal';
import backendRealisateurService from '../../services/backendRealisateursService';
import FilmModal from './FilmModal';
import { FaCog } from 'react-icons/fa';
import '../../styles/boutonmodifier.css';

const Realisateurs = () => {
    const [realisateurs, setRealisateurs] = useState([]);
    const [filteredRealisateurs, setFilteredRealisateurs] = useState([]);
    const [isFilmModalOpen, setIsFilmModalOpen] = useState(false); // Add film modal state
    const [isModifierButtonClicked, setIsModifierButtonClicked] = useState(false);
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
            if (realisateur.id !== undefined) {
                setSelectedRealisateur(realisateur);

                // Open the modification modal on realisateur click
                setModifyModalOpen(true);

                // Fetch and show films in the film modal
                const filmsData = await backendRealisateurService.fetchRealisateurFilms(
                    realisateur.id
                );

                if (Array.isArray(filmsData.data)) {
                    setModalFilms({
                        data: filmsData.data,
                        realisateurName: realisateur.nom,
                    });

                    // Open the film modal
                    setIsFilmModalOpen(true);
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

    const handleFilmModalClose = () => {
        setIsFilmModalOpen(false); // Use setIsFilmModalOpen to close the film modal
        setModalFilms({ data: [], realisateurName: '' });
    };

    const handleSaveModifiedRealisateur = async (modifiedInfo, isModifierButtonClicked) => {
        try {
            if (selectedRealisateur && isModifierButtonClicked) {
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
                console.error('Selected realisateur is undefined or Modifier button is not clicked.');
            }
        } catch (error) {
            console.error('Error updating realisateur:', error);
            // Handle error as needed
        }
    };
    return (
        <div>
            <RealisateursTitle/>
            <RealisateursSearchBar onSearch={handleSearch}/>
            <div className="modify-button-container">
                <button className="modify-button" onClick={() => setIsModifierButtonClicked(true)}>
                    Modifier Realisateurs <FaCog className="modify-button-icon"/>
                </button>
            </div>
            {isModifierButtonClicked && (
                <ModifyRealisateurModal
                    isOpen={modifyModalOpen}
                    handleClose={() => setIsModifierButtonClicked(false)}
                    realisateur={selectedRealisateur}
                    onSave={(modifiedInfo) =>
                        handleSaveModifiedRealisateur(modifiedInfo, isModifierButtonClicked)
                    }
                />
            )}
            <RealisateurList
                realisateurs={filteredRealisateurs}
                handleRealisateurClick={handleRealisateurClick}
            />
            {isFilmModalOpen && (
                <FilmModal // Use FilmModal instead of Modal
                    isOpen={isFilmModalOpen}
                    handleClose={handleFilmModalClose} // Use handleFilmModalClose to close the film modal
                    films={modalFilms}
                />
            )}
        </div>
    );
};

export default Realisateurs;
