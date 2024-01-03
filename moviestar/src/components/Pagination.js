// Pagination.js

import React from 'react';
import { Pagination as BootstrapPagination } from 'react-bootstrap';

const Pagination = ({ currentPage, totalPages, onPreviousPage, onNextPage }) => {
  return (
    <div className="custom-pagination">
      <button className="custom-pagination-button" disabled={currentPage === 1} onClick={onPreviousPage}>
        Précédent
      </button>
      <span className="custom-pagination-current"> Page {currentPage} </span>
      <button className="custom-pagination-button" disabled={currentPage === totalPages} onClick={onNextPage}>
        Suivant
      </button>
    </div>
  );
};

export default Pagination;