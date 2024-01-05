import React, { useState, useEffect } from 'react';
import RealisateursList from './RealisateursList';
import Pagination from '../../components/Pagination';
import SearchBar from './SearchBar';
import '../../../../../../../../IdeaProjects/Projets/Frontend/moviestar/src/styles/realisateurs.css';
import backendServiceRealisateurs from '../../backendServices/backendServiceRealisateurs';

const Realisateurs = () => {
  const [realisateurs, setRealisateurs] = useState([]);
  const [selectedItemIndex, setSelectedItemIndex] = useState(null);
  const [currentPage, setCurrentPage] = useState(1);
  const [pageSize, setPageSize] = useState(10);
  const [totalPages, setTotalPages] = useState(1);

  const fetchRealisateursData = async (page, size) => {
    try {
      const realisateursData = await backendServiceRealisateurs.fetchRealisateurs(
          page,
          size
      );

      setRealisateurs(realisateursData.content || []);
      setTotalPages(realisateursData.totalPages);
      setPageSize(realisateursData.pageSize);
    } catch (error) {
      console.error('Error fetching réalisateur data:', error);
    }
  };

  useEffect(() => {
    fetchRealisateursData(currentPage, pageSize);
  }, [currentPage, pageSize]);

  const handleRealisateurClick = async (realisateur, index) => {
    try {
      console.log('Clicked Realisateur:', realisateur);

      if (realisateur.idRealisateur !== undefined) {
        console.log('Realisateur ID:', realisateur.idRealisateur);

        const filmsData = await backendServiceRealisateurs.fetchRealisateurFilms(
            realisateur.idRealisateur
        );

        if (filmsData && Array.isArray(filmsData)) {
          setRealisateurs((prevRealisateurs) => {
            const updatedRealisateurs = [...prevRealisateurs];
            updatedRealisateurs[index] = {
              ...realisateur,
              films: filmsData,
            };
            return updatedRealisateurs;
          });
          setSelectedItemIndex(index);
        } else {
          console.error('Invalid or missing films data.');
        }
      } else {
        console.error('Realisateur ID is undefined.');
      }
    } catch (error) {
      console.error('Error fetching films:', error);
    }
  };

  const handlePageChange = (newPage) => {
    setCurrentPage(newPage);
  };

  const handleSearch = async (searchTerm) => {
    try {
      const searchData = await backendServiceRealisateurs.searchRealisateurs(
          searchTerm,
          currentPage,
          pageSize
      );

      setRealisateurs(searchData.content || []);
      setTotalPages(searchData.totalPages);
      setPageSize(searchData.pageSize);
    } catch (error) {
      console.error('Error searching réalisateur data:', error);
    }
  };

  return (
      <div className="realisateur-container">
        <SearchBar onSearch={handleSearch} />
        <RealisateursList
            realisateurs={realisateurs}
            selectedItemIndex={selectedItemIndex}
            handleRealisateurClick={handleRealisateurClick}
            state={{ currentPage, pageSize, totalPages }}
        />
        <Pagination
            currentPage={currentPage}
            totalPages={totalPages}
            onPageChange={handlePageChange}
            onPreviousPage={() => handlePageChange(currentPage - 1)}
            onNextPage={() => handlePageChange(currentPage + 1)}
        />
      </div>
  );
};

export default Realisateurs;
