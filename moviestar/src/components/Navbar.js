// src/components/Navbar.js
import React from 'react';
import {Link, NavLink} from 'react-router-dom';
import '../styles/navbar.css';

const Navbar = () => {
    return (
        <nav>
            <ul>
                <li>
                    <NavLink to="/" exact activeClassName="active">
                        Home
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/films" activeClassName="active">
                        Films
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/genres" activeClassName="active">
                        Genres
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/acteurs" activeClassName="active">
                        Acteurs
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/rechercheavancee" activeClassName="active">
                        Recherche Avancée
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/realisateurs" activeClassName="active">
                        Réalisateurs
                    </NavLink>
                </li>
            </ul>
        </nav>
    );
};

export default Navbar;