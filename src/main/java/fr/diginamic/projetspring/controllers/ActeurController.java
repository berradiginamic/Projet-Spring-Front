package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.services.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des acteurs.
 */
@RestController
@RequestMapping("/acteurs")
public class ActeurController {

    /** Service gérant la logique métier des acteurs. */
    @Autowired
    private ActeurService acteurService;

    /**
     * Endpoint pour obtenir la liste de tous les acteurs.
     *
     * @return La liste de tous les acteurs.
     */
    @GetMapping
    public ResponseEntity<List<Acteur>> getAllActeurs() {
        List<Acteur> acteurs = acteurService.getAllActeurs();
        return new ResponseEntity<>(acteurs, HttpStatus.OK);
    }

    /**
     * Endpoint pour obtenir un acteur par son identifiant.
     *
     * @param acteurId Identifiant de l'acteur à récupérer.
     * @return L'acteur correspondant à l'identifiant.
     */
    @GetMapping("/{acteurId}")
    public Acteur getActeurById(@PathVariable("acteurId") Integer acteurId) {
        return acteurService.getActeurById(acteurId);
    }

    /**
     * Endpoint pour créer un nouvel acteur.
     *
     * @param acteur L'acteur à créer.
     * @return L'acteur créé.
     */
    @PostMapping
    public ResponseEntity<Acteur> createActeur(@RequestBody Acteur acteur) {
        Acteur createdActeur = acteurService.createActeur(acteur);
        return new ResponseEntity<>(createdActeur, HttpStatus.CREATED);
    }

    /**
     * Endpoint pour mettre à jour un acteur existant.
     *
     * @param acteurId     Identifiant de l'acteur à mettre à jour.
     * @param acteur Les nouvelles données de l'acteur.
     * @return L'acteur mis à jour.
     */
    @PutMapping("/{acteurId}")
    public Acteur updateActeur(@PathVariable(name ="acteurId") Integer acteurId, @RequestBody Acteur acteur) {
        return acteurService.updateActeur(acteurId, acteur);
    }

    /**
     * Endpoint pour supprimer un acteur par son identifiant.
     *
     * @param acteurId Identifiant de l'acteur à supprimer.
     */
    @DeleteMapping("/{acteurId}")
    public void deleteActeur(@PathVariable(name ="acteurId") Integer acteurId) {
        acteurService.deleteActeur(acteurId);
    }

    // Implementation des requetes:
    // Tache 1: Extraire tous les films (nom et années de sortie) d’un acteur donné
    @GetMapping("/{acteurId}/films")
    public List<Object[]> getFilmsByActeurId(@PathVariable("acteurId") Integer acteurId) {
        return acteurService.findFilmsByActeurId(acteurId);
    }

    // Tache 6:  Extraire les acteurs communs à 2 films donnés
    @GetMapping("/in-films")
    public List<Object[]> getActeursInFilms(@RequestParam("filmId1") Integer filmId1,
                                            @RequestParam("filmId2") Integer filmId2) {
        return acteurService.findActeursInFilms(filmId1, filmId2);
    }
}