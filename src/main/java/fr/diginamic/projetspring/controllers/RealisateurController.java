package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.services.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour la gestion des réalisateurs.
 */
@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {

    /** Service gérant la logique métier des réalisateurs. */
    private final RealisateurService realisateurService;

    /**
     * Constructeur du contrôleur avec injection du service.
     *
     * @param realisateurService Service gérant la logique métier des réalisateurs.
     */
    @Autowired
    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    /**
     * Endpoint pour obtenir la liste de tous les réalisateurs.
     *
     * @return La liste de tous les réalisateurs.
     */
    @GetMapping("/all")
    public List<Realisateur> getAllRealisateurs() {
        return realisateurService.getAllRealisateurs();
    }

    /**
     * Endpoint pour obtenir un réalisateur par son identifiant.
     *
     * @param id Identifiant du réalisateur à récupérer.
     * @return Le réalisateur correspondant à l'identifiant.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Realisateur> getRealisateurById(@PathVariable("id") Long id) {
        Optional<Realisateur> realisateur = realisateurService.getRealisateurById(id);
        return realisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint pour sauvegarder un nouveau réalisateur.
     *
     * @param realisateur Le réalisateur à sauvegarder.
     * @return Le réalisateur sauvegardé.
     */
    @PostMapping("/save")
    public Realisateur saveRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.saveRealisateur(realisateur);
    }

    /**
     * Endpoint pour supprimer un réalisateur par son identifiant.
     *
     * @param id Identifiant du réalisateur à supprimer.
     */

    @PutMapping("/{id}")
    public Realisateur updateRealisateur(@PathVariable Long id, @RequestBody Realisateur realisateur) {
        return realisateurService.updateRealisateur(id, realisateur);
    }
    @DeleteMapping("/{id}")
    public void deleteRealisateurById(@PathVariable("id") Long id) {
        realisateurService.deleteRealisateurById(id);
    }

    // Ajoutez d'autres méthodes d'endpoint au besoin
}
