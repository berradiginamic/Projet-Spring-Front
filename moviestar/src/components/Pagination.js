// Pagination.js

import React from 'react';
import { Pagination as BootstrapPagination } from 'react-bootstrap';
import '../styles/styles.css'

const Pagination = ({ currentPage, totalPages, onPreviousPage, onNextPage, onPageChange }) => {
  const handlePrevClick = () => {
    if (currentPage > 1) {
      onPreviousPage();
      onPageChange(currentPage - 1);
    }
  };

  const handleNextClick = () => {
    if (currentPage < totalPages) {
      onNextPage();
      onPageChange(currentPage + 1);
    }
  };

  return (
    <div className="custom-pagination">
      <button className="custom-pagination-button" disabled={currentPage === 1} onClick={handlePrevClick}>
        Précédent
      </button>
      <span className="custom-pagination-current"> Page {currentPage} </span>
      <button className="custom-pagination-button" disabled={currentPage === totalPages} onClick={handleNextClick}>
        Suivant
      </button>
    </div>
  );
};

export default Pagination;
