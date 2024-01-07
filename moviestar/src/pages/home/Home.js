// Home.js
import React from 'react';
// eslint-disable-next-line
import { Link } from 'react-router-dom';
import { useSpring, animated } from 'react-spring';
import '../../styles/home.css'; // Assurez-vous d'importer le fichier de styles CSS

const Home = () => {
  const titleAnimation = useSpring({
    opacity: 1,
    from: { opacity: 0 },
    delay: 500, // Délai pour retarder l'animation
  });

    const windowAnimation = useSpring({
        opacity: 1,
        from: { opacity: 0 },
        delay: 1000,
        marginTop: -100, // Proper margin-top value for downward movement
    });

  return (
    <div className="home-page-container">
      <animated.h1 style={titleAnimation} className="title">
        Bienvenue sur Film Harmonie
      </animated.h1>
      <img
        src={`${process.env.PUBLIC_URL}/images/cinemaa.jpg`}
        alt="Cinema"
        className="full-width-image"
      />

      <animated.div style={windowAnimation} className="info-window">
        <p>
          Bienvenue sur Film Harmonie - Votre Source Infinie de Cinéma 🎬✨. Explorez un univers cinématographique sans limites. Retrouvez instantanément vos réalisateurs, acteurs, et films préférés notés par le grand public. Plongez dans une variété de genres, explorez des collaborations uniques d'acteurs, et découvrez le classement des meilleurs films de tous les temps. Bienvenue sur Film Harmonie 🌟🍿.
        </p>
      </animated.div>
    </div>
  );
};

export default Home;