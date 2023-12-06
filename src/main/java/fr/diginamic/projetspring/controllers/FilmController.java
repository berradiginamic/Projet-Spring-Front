package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.entities.RoleFilm;
import fr.diginamic.projetspring.services.ActeurService;
import fr.diginamic.projetspring.services.FilmService;
import fr.diginamic.projetspring.services.RoleFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Contrôleur REST pour la gestion des films.
 */
@RestController
@RequestMapping("/films")
public class FilmController {

    /** Service gérant la logique métier des films. */
    @Autowired
    private FilmService filmService;
    @Autowired
    private RoleFilmService roleFilmService;

    // Opérations CRUD pour les films

    /**
     * Endpoint pour obtenir la liste de tous les films.
     *
     * @return La liste de tous les films.
     */
    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/par-genre/{genreType}")
    public ResponseEntity<List<Film>> getFilmsByGenre(@PathVariable("genreType") String genreType) {
        // Utilisez le service pour rechercher les films par genre
        List<Film> films = filmService.getFilmsByGenre(genreType);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    /**
     * Endpoint pour obtenir un film par son identifiant.
     *
     * @param filmId Identifiant du film à récupérer.
     * @return Le film correspondant à l'identifiant.
     */
    @GetMapping("/{filmId}")
    public ResponseEntity<Film> getFilmById(@PathVariable("filmId") Integer filmId) {
        Optional<Film> film = Optional.ofNullable(filmService.getFilmById(filmId));
        return film.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint pour créer un nouveau film.
     *
     * @param film Le film à créer.
     * @return Le film créé.
     */
    @PostMapping
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        Film createdFilm = filmService.createFilm(film);
        return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
    }

    /**
     * Endpoint pour mettre à jour un film existant.
     *
     * @param filmId   Identifiant du film à mettre à jour.
     * @param film Les nouvelles données du film.
     * @return Le film mis à jour.
     */
    @PutMapping("/{filmId}")
    public Film updateFilm(@PathVariable("filmId") Integer filmId, @RequestBody Film film) {
        return filmService.updateFilm(filmId, film);
        }


    /**
     * Endpoint pour supprimer un film par son identifiant.
     *
     * @param filmId Identifiant du film à supprimer.
     * @return Réponse indiquant le succès de l'opération.
     */
    @DeleteMapping("/{filmId}")
    public void deleteFilm(@PathVariable Integer filmId) {
        filmService.deleteFilm(filmId);
    }

    // Opérations spécifiques

    // Ajoutez d'autres méthodes selon vos besoins
    /**
     * Endpoint pour obtenir la liste des rôles dans un film.
     *
     * @ filmId Identifiant du film.
     * @return La liste des rôles dans le film.
     */
    /*@GetMapping("/realisateur/{realisateurId}")
    public List<Film> findByRealisateurId(@PathVariable("realisateurId") Integer realisateurId) {
        return filmService.findByRealisateurId(realisateurId);
    }*/

    @GetMapping("/byGenres")
    public ResponseEntity<List<Film>> getFilmsByGenres(@RequestParam Set<String> genreTypes) {
        try {
            List<Film> films = filmService.getFilmsByGenreTypes(genreTypes);
            return new ResponseEntity<>(films, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byGenre")
    public List<Film> getFilmsByGenre(@RequestParam String genreType) {
        // Example of using findByGenres_Type
        return filmService.getFilmsByGenre(genreType);
    }
}
