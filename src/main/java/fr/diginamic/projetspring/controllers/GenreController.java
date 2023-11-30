package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    // Ajoutez des méthodes d'endpoint au besoin

    // Exemple: Endpoint pour récupérer tous les genres
    @GetMapping("/all")
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    // Exemple: Endpoint pour récupérer un genre par son nom
    @GetMapping("/{name}")
    public Genre getGenreByName(@PathVariable String name) {
        return genreService.getGenreByName(name);
    }

    // Exemple: Endpoint pour enregistrer un nouveau genre
    @PostMapping("/save")
    public Genre saveGenre(@RequestBody Genre genre) {
        return genreService.saveGenre(genre);
    }

    // Exemple: Endpoint pour supprimer un genre par son identifiant
    @DeleteMapping("/{id}")
    public void deleteGenreById(@PathVariable Long id) {
        genreService.deleteGenreById(id);
    }
}
