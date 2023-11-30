package fr.diginamic.projetspring.controllers;

import fr.diginamic.projetspring.entities.Rôle;
import fr.diginamic.projetspring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rôle> getRoleById(@PathVariable Long id) {
        Optional<Rôle> role = roleService.getRoleById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Rôle> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping
    public ResponseEntity<Rôle> createRole(@RequestBody Rôle role) {
        Rôle savedRole = roleService.saveRole(role);
        return ResponseEntity.ok(savedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

    // Ajoutez d'autres méthodes d'endpoint au besoin
}
