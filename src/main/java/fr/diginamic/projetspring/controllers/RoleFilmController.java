package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.RoleFilm;
import fr.diginamic.projetspring.services.RoleFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleFilmController {

    private final RoleFilmService roleFilmService;

    @Autowired
    public RoleFilmController(RoleFilmService roleFilmService) {
        this.roleFilmService = roleFilmService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleFilm> getRoleById(@PathVariable Long id) {
        Optional<RoleFilm> role = roleFilmService.getRoleById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<RoleFilm> getAllRoles() {
        return roleFilmService.getAllRoles();
    }

    @PostMapping
    public ResponseEntity<RoleFilm> saveRoleFilm(@RequestBody RoleFilm role) {
        RoleFilm savedRole = roleFilmService.saveRoleFilm(role);
        return ResponseEntity.ok(savedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleFilm(@PathVariable Long id) {
        roleFilmService.deleteRoleFilm(id);
        return ResponseEntity.noContent().build();
    }

    // Ajoutez d'autres méthodes d'endpoint au besoin
}
