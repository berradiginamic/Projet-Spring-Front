import React from "react";
import Header from "./Components/Header";
import Footer from "./Components/Footer";
import { BrowserRouter, Routes, Route } from "react-router-dom";
// import Trending from "./Pages/Trending";
// import Acteurs from "./Pages/Acteurs";
// import Films from "./Pages/Films";
// import Genres from "./Pages/Genres";
// import Realisateurs from "./Pages/Realisateurs";
// import Recherche from "./Pages/Recherche";
// import SingleMovie from "./Pages/SingleMovie";
// import Erreur from "./Pages/Erreur";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          {/* <Route path="/" element={<Home />} exact /> */}
          {/* Home page is denoted with ‘/’ symbol */}

          {/* <Route path="/films" element={<Films />} /> // page films */}
          {/* <Route path="/acteurs" element={<Acteurs />} /> // Page acteurs */}
          {/* <Route path="/recherche" element={<Recherche />} /> // Custom Search Page */}
          {/* <Route path="*" element={<Error />} /> // Error Page */}
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  );
};

export default App;