import React from 'react';
import { Link } from 'react-router-dom'; // Assuming you use React Router
import { FaPencilAlt } from 'react-icons/fa'; // Assuming you have a library like react-icons

const ModifyRealisateurButton = ({ realisateurId }) => {
  const modifyLink = `/modify-realisateur/${realisateurId}`; // Replace with your actual route

  return (
    <Link to={modifyLink}>
      <div className="modify-realisateur-button">
        <FaPencilAlt />
      </div>
    </Link>
  );
};

export default ModifyRealisateurButton;