package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.services.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des acteurs.
 */
@RestController
@RequestMapping("/acteurs")
public class ActeurController {

    /** Service gérant la logique métier des acteurs. */
    private final ActeurService acteurService;

    /**
     * Constructeur du contrôleur avec injection du service.
     *
     * @param acteurService Service gérant la logique métier des acteurs.
     */
    @Autowired
    public ActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    /**
     * Endpoint pour obtenir la liste de tous les acteurs.
     *
     * @return La liste de tous les acteurs.
     */
    @GetMapping
    public List<Acteur> getAllActeurs() {
        return acteurService.getAllActeurs();
    }

    /**
     * Endpoint pour obtenir un acteur par son identifiant.
     *
     * @param id Identifiant de l'acteur à récupérer.
     * @return L'acteur correspondant à l'identifiant.
     */
    @GetMapping("/{id}")
    public Acteur getActeurById(@PathVariable Long id) {
        return acteurService.getActeurById(id);
    }

    /**
     * Endpoint pour créer un nouvel acteur.
     *
     * @param acteur L'acteur à créer.
     * @return L'acteur créé.
     */
    @PostMapping
    public Acteur createActeur(@RequestBody Acteur acteur) {
        return acteurService.createActeur(acteur);
    }

    /**
     * Endpoint pour mettre à jour un acteur existant.
     *
     * @param id     Identifiant de l'acteur à mettre à jour.
     * @param acteur Les nouvelles données de l'acteur.
     * @return L'acteur mis à jour.
     */
    @PutMapping("/{id}")
    public Acteur updateActeur(@PathVariable Long id, @RequestBody Acteur acteur) {
        return acteurService.updateActeur(id, acteur);
    }

    /**
     * Endpoint pour supprimer un acteur par son identifiant.
     *
     * @param id Identifiant de l'acteur à supprimer.
     */
    @DeleteMapping("/{id}")
    public void deleteActeur(@PathVariable Long id) {
        acteurService.deleteActeur(id);
    }
}
