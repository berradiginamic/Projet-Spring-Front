import React, { useEffect, useState } from 'react';
import FilmsTitle from './FilmsTitle'; // Update the import
import FilmsSearchBar from './FilmsSearchBar'; // Update the import
import FilmsList from './FilmsList'; // Update the import
import ModifyFilmModal from './ModifyFilmModal'; // Update the import
import backendFilmService from '../../services/backendFilmService'; // Update the import
import { FaCog } from 'react-icons/fa';
import '../../styles/boutonmodifier.css';
import RoleInfo from './RoleInfo'; // Import the new FilmInfo component

const Films = () => { // Update the component name
    const [films, setFilms] = useState([]); // Update state variable names
    const [filteredFilms, setFilteredFilms] = useState([]); // Update state variable names
    const [isModifierButtonClicked, setIsModifierButtonClicked] = useState(false);
    const [modifyModalOpen, setModifyModalOpen] = useState(false);
    const [selectedFilm, setSelectedFilm] = useState(null);
    const [currentPage, setCurrentPage] = useState(1);
    const [totalPages, setTotalPages] = useState(1);

    const handleCloseFilmInfo = () => {
        setSelectedFilm(null);
    };

    useEffect(() => {
        backendFilmService.getAllFilms().then((response) => { // Update API call
            setFilms(response.data);
            setFilteredFilms(response.data);
        });
    }, []);

    const handleSearch = (searchTerm) => {
        const filteredList = films.filter((film) => // Update variable names
            film.nom.toLowerCase().includes(searchTerm.toLowerCase()) // Update variable names
        );
        setFilteredFilms(filteredList);
    };

    const handleFilmClick = async (film) => {
        try {
            if (film.id !== undefined) {
                setSelectedFilm(film);

                // Open the modification modal on film click
                setModifyModalOpen(true);

                // Fetch and show roles in the film section
                const rolesData = await backendFilmService.getActorsAndCharactersByFilmId(
                    film.id
                );

                if (Array.isArray(rolesData.data)) {
                    // Update the state with the roles
                    setSelectedFilm({
                        ...film,
                        roles: rolesData.data.map(role => ({
                            acteur: { nom: role[0] },
                            personnage: role[1],
                        })),
                    });
                } else {
                    console.error('Invalid or missing roles data:', rolesData);
                }
            } else {
                console.error('Film ID is undefined.');
            }
        } catch (error) {
            console.error('Error fetching roles:', error);
        }
    };

    const handleSaveModifiedFilm = async (modifiedInfo, isModifierButtonClicked) => {
        try {
            if (selectedFilm && isModifierButtonClicked) {
                // Send a request to update the film in the backend
                await backendFilmService.updateFilm( // Update API call
                    selectedFilm.filmId,
                    modifiedInfo
                );

                // Update the state with the modified film
                setFilms((prevFilms) =>
                    prevFilms.map((f) =>
                        f && f.id === selectedFilm.id ? { ...f, ...modifiedInfo } : f // Update variable names
                    )
                );

                setModifyModalOpen(false);
                setSelectedFilm(null); // Reset selected film after modification
            } else {
                console.error('Selected film is undefined or Modifier button is not clicked.');
            }
        } catch (error) {
            console.error('Error updating film:', error);
            // Handle error as needed
        }
    };

    return (
        <div>
            <FilmsTitle /> {/* Update component name */}
            <FilmsSearchBar onSearch={handleSearch} /> {/* Update component name */}
            <div className="modify-button-container">
                <button className="modify-button" onClick={() => setIsModifierButtonClicked(true)}>
                    Modifier Films <FaCog className="modify-button-icon" />
                </button>
            </div>
            {isModifierButtonClicked && (
                <ModifyFilmModal // Update component name
                    isOpen={modifyModalOpen}
                    handleClose={() => setIsModifierButtonClicked(false)}
                    film={selectedFilm}
                    onSave={(modifiedInfo) =>
                        handleSaveModifiedFilm(modifiedInfo, isModifierButtonClicked)
                    }
                />
            )}
            <div>
                <div className="films-list">
                    <FilmsList
                        films={filteredFilms}
                        handleFilmClick={(film) =>
                            handleFilmClick({ ...film, id: film.filmId })
                        }
                    />
                </div>
                {selectedFilm && <RoleInfo selectedFilm={selectedFilm} onClose={handleCloseFilmInfo} />}
            </div>
        </div>
    );
};

export default Films;