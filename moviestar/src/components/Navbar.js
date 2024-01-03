import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/styles.css'; // Import styles


const Navbar = () => {
    return (
        <nav>
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/acteurs">Acteurs</Link></li>
                <li><Link to="/films">Films</Link></li>
                <li><Link to="/genres">Genres</Link></li>
                <li><Link to="/search">Recherche Avancée</Link></li>
                <li><Link to="/realisateurs">Realisateurs</Link></li>
            </ul>
        </nav>
    );
};

export default Navbar;