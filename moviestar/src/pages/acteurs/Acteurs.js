import React, { useEffect, useState } from 'react';
import ActeursTitle from './ActeursTitle';
import ActeurSearchBar from '../../components/ActeurSearchBar';
import ActeursList from "./ActeursList";
import ModifyActeurModal from './ModifyActeurModal';
import backendActeursService from "../../services/backendActeursService";
import Modal from './Modal';

const Acteurs = () => {
    const [acteurs, setActeurs] = useState([]);
    const [filteredActeurs, setFilteredActeurs] = useState([]);
    const [isModalOpen, setModalOpen] = useState(false);
    const [modalFilms, setModalFilms] = useState({ data: [], acteurName: '' });
    const [modifyModalOpen, setModifyModalOpen] = useState(false);
    const [selectedActeur, setSelectedActeur] = useState(null);

    useEffect(() => {
        backendActeursService.getAllActeurs()
            .then((response) => {
                console.log('Données des acteurs:', response.data);
                setActeurs(response.data);
                setFilteredActeurs(response.data);
            })
            .catch((error) => {
                console.error('Erreur lors de la récupération des acteurs:', error);
            });
    }, []);

    const handleSearch = (searchTerm) => {
        const filteredList = acteurs.filter((acteur) =>
            acteur.nom.toLowerCase().includes(searchTerm.toLowerCase())
        );
        setFilteredActeurs(filteredList);
    };

    const handleActeurClick = async (acteur) => {
        try {
            console.log('Clicked Acteur:', acteur);

            if (acteur.acteurId !== undefined) {
                console.log('Acteur ID:', acteur.acteurId);

                const filmsData = await backendActeursService.fetchActeurFilms(
                    acteur.acteurId
                );

                console.log('Films Data:', filmsData);

                if (Array.isArray(filmsData.data)) {
                    setModalFilms({
                        data: filmsData.data,
                        acteurName: acteur.nom,
                    });

                    setModalOpen(true);
                    setSelectedActeur(acteur);
                } else {
                    console.error('Invalid or missing films data:', filmsData);
                }
            } else {
                console.error('Acteur ID is undefined.');
            }
        } catch (error) {
            console.error('Error fetching films:', error);
        }
    };

    const handleModalClose = () => {
        setModalOpen(false);
        setModalFilms({ data: [], acteurName: '' });
    };

    const handleModifyActeur = (acteur) => {
        setSelectedActeur(acteur);
        setModifyModalOpen(true);
    };

    const handleSaveModifiedActeur = (modifiedInfo) => {
        console.log('Trying to save Modified Acteur Info:', modifiedInfo);

        setActeurs((prevActeurs) =>
            prevActeurs.map((r) =>
                r && r.id === selectedActeur.id ? { ...r, ...modifiedInfo } : r
            )
        );

        setModifyModalOpen(false);
        setSelectedActeur(null); // Reset selected acteur after modification
    };

    console.log('Acteurs avant rendu :', filteredActeurs);

    return (
        <div>
            <ActeursTitle />
            <ActeurSearchBar onSearch={handleSearch} />
            <button onClick={() => handleModifyActeur(selectedActeur)}>
                Modifier Acteurs
            </button>
            <ActeursList
                acteurs={filteredActeurs}
                handleActeurClick={handleActeurClick}
            />

            {/* Add Modal component */}
            <Modal isOpen={isModalOpen} handleClose={handleModalClose} films={modalFilms} />
            {/* Add ModifyActeurModal */}
            <ModifyActeurModal
                isOpen={modifyModalOpen}
                handleClose={() => setModifyModalOpen(false)}
                acteur={selectedActeur}
                onSave={handleSaveModifiedActeur}
            />
        </div>
    );
};

export default Acteurs;