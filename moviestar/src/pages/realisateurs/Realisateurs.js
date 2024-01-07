import React, { useEffect, useState } from 'react';
import RealisateursTitle from './RealisateursTitle';
import RealisateursSearchBar from './RealisateursSearchBar';
import RealisateurList from './RealisateurList';
import ModifyRealisateurModal from './ModifyRealisateurModal';
import backendRealisateurService from '../../services/backendRealisateursService';
import { FaCog } from 'react-icons/fa';
import '../../styles/boutonmodifier.css';
import FilmInfo from './FilmInfo'; // Import the new FilmInfo component


const Realisateurs = () => {
    const [realisateurs, setRealisateurs] = useState([]);
    const [filteredRealisateurs, setFilteredRealisateurs] = useState([]);
    const [isModifierButtonClicked, setIsModifierButtonClicked] = useState(false);
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

                // Fetch and show films in the film section
                const filmsData = await backendRealisateurService.fetchRealisateurFilms(
                    realisateur.id
                );

                if (Array.isArray(filmsData.data)) {
                    // Update the state with the films
                    setSelectedRealisateur({
                        ...realisateur,
                        films: filmsData.data,
                    });
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
            <div>
                <div className="realisateurs-list">
                    <RealisateurList
                        realisateurs={filteredRealisateurs}
                        handleRealisateurClick={(realisateur) =>
                            handleRealisateurClick({...realisateur, id: realisateur.idRealisateur})
                        }
                    />
                </div>
                {selectedRealisateur && <FilmInfo selectedRealisateur={selectedRealisateur} />}
            </div>
        </div>
    );
};

export default Realisateurs;
