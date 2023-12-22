import React, { useState, useEffect } from "react";
import Pagination from "../Components/Pagination";
import Genre from "../Components/Genre";

const Movies = () => {
  const [state, setState] = useState([]); //store the fetched data
  const [page, setPage] = useState(1); //keep a track of the page numbers
  const [genre, setGenre] = useState([]); //used to store the origional genre values
  const [value, setValue] = useState([]); //used to store the selected genre values
  const genreURL = useGenre(value);

  const fetchTrending = async () => {
    const data = await fetch(`
    https://api.themoviedb.org/3/discover/movie?api_key=3d820eab8fd533d2fd7e1514e86292ea&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=${page}&with_genres=${genreURL}`);
    const dataJ = await data.json();
    setState(dataJ.results);
  };

  useEffect(() => {
    fetchTrending();
  }, [page, genreURL]);


<div className="container">
<div className="row py-5 my-5">
<div className="col-12 mt-2 mb-4 fs-1 fw-bold text-decoration-underline head d-flex justify-content-center align-items-center">
  <i className="fas fa-fire mx-4 text-danger"></i>
  <h4 className="fs-2">Trending Today</h4>
  <i className="fas fa-fire mx-4 text-danger"></i>
</div>
</div>
</div>

return (
    <>
{
  state.map((Val) => {
    const {
      nom,
      anneeSortie,
      langue,
      pays,
      rating,
      genre,
      filmId,
    } = Val;
    return (
      <>
        <div
          key={filmId}
          className="col-md-3 col-sm-4 py-3 d-flex justify-content-center g-4"
          id="card"
        >
          <div className="card bg-dark" key={filmId}>
            <div className="card-body">
              <h5 className="card-title text-center fs-5">{nom || anneeSortie}</h5>
              <div className="d-flex fs-6 align-items-center justify-content-evenly movie">
                <div>{rating || genre}</div>
                <div>{langue || pays}</div>
              </div>
            </div>
          </div>
        </div>
      </>
    );
  });
}

return default Films;