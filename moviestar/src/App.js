import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './pages/home/Home';
import Acteurs from './pages/acteurs/Acteurs';
import Films from './pages/films/Films';
import Genres from './pages/genres/Genres';
import RechercheAvancee from './pages/rechercheavancee/RechercheAvancee';
import Realisateurs from './pages/realisateurs/Realisateurs';
import './styles/global.css';

const App = () => {
  return (
      <Router>
        <div>
          <Navbar />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/acteurs" element={<Acteurs />} />
            <Route path="/films" element={<Films />} />
            <Route path="/genres" element={<Genres />} />
            <Route path="/rechercheAvancee" element={<RechercheAvancee />} />
            <Route path="/realisateurs" element={<Realisateurs />} />
          </Routes>
        </div>
      </Router>
  );
};

export default App;