import axios from 'axios';

const backendRechercheService = {
    getActeursInFilms: (filmId1, filmId2) =>
        axios.get(`/acteurs/in-films`, {
            params: {
                filmId1: parseInt(filmId1),
                filmId2: parseInt(filmId2),
            },
        }),

    getFilmsByTwoActors: (acteurId1, acteurId2) =>
        axios.get(`/films/by-two-actors`, {
            params: {
                acteurId1: parseInt(acteurId1),
                acteurId2: parseInt(acteurId2),
            },
        }),

    getFilmsReleasedBetweenYears: (startYear, endYear) =>
        axios.get(`/films/released-between-years`, {
            params: {
                startYear: parseInt(startYear),
                endYear: parseInt(endYear),
            },
        }),

    getFilmsReleasedBetweenYearsAndByActeur: (startYear, endYear, acteurId) =>
        axios.get(`/films/betweenYearsAndByActeur`, {
            params: {
                startYear: parseInt(startYear),
                endYear: parseInt(endYear),
                acteurId: parseInt(acteurId)
            },
        }),
};

export default backendRechercheService;