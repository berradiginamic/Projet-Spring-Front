package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des genres.
 */
@RestController
@RequestMapping("/genres") // ajouter /api/genres si besoin
public class GenreController {

    /** Service gérant la logique métier des genres. */
    @Autowired
    private GenreService genreService;

    /**
     * Constructeur du contrôleur avec injection du service.
     *
     * getAllGenres Service gérant la logique métier des genres.
     */
    // Ajoutez des endpoints pour les opérations CRUD sur les genres si nécessaire
    @GetMapping public List<Genre> getAllGenres() {
        return genreService.findAll();
    }

    @GetMapping("/{genreId}")
    public Genre getGenreById(@PathVariable("genreId") Integer genreId) {
        return genreService.findById(genreId);
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        Genre createdGenre = genreService.createGenre(genre);
        return new ResponseEntity<>(createdGenre, HttpStatus.CREATED);
    }

    @PutMapping("/{genreId}")
    public Genre updateGenre(@PathVariable(name ="genreId") Integer genreId, @RequestBody Genre genre) {
        return genreService.updateGenre(genreId, genre);
    }

    @DeleteMapping("/{genreId}")
    public void deleteGenre(@PathVariable(name ="genreId") Integer genreId) {
        genreService.deleteGenre(genreId);
    }
}
