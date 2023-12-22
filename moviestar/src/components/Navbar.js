// src/components/Navbar.js
import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/acteurs">Acteurs</Link></li>
        <li><Link to="/modify-acteurs">Modifier Acteur</Link></li> {/* Add this line */}
        <li><Link to="/films-acteurs">Films d'un' Acteur</Link></li> {/* Add this line */}
        <li><Link to="/films-entre-annee">Films entre deux annees</Link></li> {/* Add this line */}
        <li><Link to="/modifier-genre">Genres</Link></li> {/* Add this line */}
      </ul>
    </nav>
  );
};

export default Navbar;