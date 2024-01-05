import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Acteurs from './pages/Acteurs/Acteurs';
import Films from './pages/Films/Films';
import Genres from './pages/Genres/Genres';
import Search from './pages/Search/Search';
import Realisateurs from './pages/Realisateurs/Realisateurs';

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
          <Route path="/search" element={<Search />} />
          <Route path="/realisateurs" element={<Realisateurs />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;