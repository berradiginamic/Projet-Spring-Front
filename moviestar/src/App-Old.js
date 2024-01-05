// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Acteurs from './pages/Acteurs/Acteurs';
import ModifyActeurs from './pages/ModifyActeurs';
import FilmActeurs from './pages/FilmActeurs';
import FilmsEntre2Annees from './pages/FilmsEntre2Annees';
import ModifierGenres from './pages/ModifierGenres';

const App = () => {
  return (
    <Router>
      <div>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/acteurs" element={<Acteurs />} /> {/* Add this line */}
          <Route path="/modify-acteurs" element={<ModifyActeurs />} /> {/* Add this line */}
          <Route path="/films-acteurs" element={<FilmActeurs />} /> {/* Add this line */}
          <Route path="/films-entre-annee" element={<FilmsEntre2Annees />} /> {/* Add this line */}
          <Route path="/modifier-genre" element={<ModifierGenres />} /> {/* Add this line */}
        </Routes>
      </div>
    </Router>
  );
};

export default App;