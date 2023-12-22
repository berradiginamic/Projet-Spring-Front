// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Acteurs from './pages/Acteurs';

const App = () => {
  return (
    <Router>
      <div>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/acteurs" element={<Acteurs />} /> {/* Add this line */}
        </Routes>
      </div>
    </Router>
  );
};

export default App;