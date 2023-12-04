package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des genres.
 */
@RestController
@RequestMapping("/genres")
public class GenreController {

    /** Service gérant la logique métier des genres. */
    private final GenreService genreService;

    /**
     * Constructeur du contrôleur avec injection du service.
     *
     * @param genreService Service gérant la logique métier des genres.
     */
    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    // Ajoutez des endpoints pour les opérations CRUD sur les genres si nécessaire

}
