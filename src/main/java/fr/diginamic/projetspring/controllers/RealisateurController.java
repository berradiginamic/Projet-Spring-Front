package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.services.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {

    private final RealisateurService realisateurService;

    @Autowired
    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @GetMapping("/all")
    public List<Realisateur> getAllRealisateurs() {
        return realisateurService.getAllRealisateurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Realisateur> getRealisateurById(@PathVariable Long id) {
        Optional<Realisateur> realisateur = realisateurService.getRealisateurById(id);
        return realisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Realisateur saveRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.saveRealisateur(realisateur);
    }

    @PutMapping("/{id}")
    public Realisateur updateRealisateur(@PathVariable Long id, @RequestBody Realisateur realisateur) {
        return realisateurService.updateRealisateur(id, realisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteRealisateurById(@PathVariable Long id) {
        realisateurService.deleteRealisateurById(id);
    }
    // Ajoutez d'autres méthodes d'endpoint au besoin
}
