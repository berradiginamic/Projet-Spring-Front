// Home.js
import React from 'react';
import '../../styles/home.css';

const Home = () => {
    return (
        <div className="home-page-container">
            <h1 className="title">
                Bienvenue sur Film Harmonie
            </h1>
            <img
                src={`${process.env.PUBLIC_URL}/images/cinemaa.jpg`}
                alt="Cinema"
                className="full-width-image"
            />

            <div className="info-window">
                <p>
                    🎬✨ Bienvenue sur Film Harmonie - Votre Source Infinie de Cinéma. Explorez un univers cinématographique sans limites. Retrouvez instantanément vos réalisateurs, acteurs, et films préférés notés par le grand public. Plongez dans une variété de genres, explorez des collaborations uniques d'acteurs, et découvrez le classement des meilleurs films de tous les temps. Bienvenue sur Film Harmonie 🌟🍿
                </p>
            </div>
        </div>
    );
};

export default Home;
