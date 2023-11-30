package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.RoleFilm;
import fr.diginamic.projetspring.repositories.RoleFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleFilmService {

    private final RoleFilmRepository roleRepository;

    @Autowired
    public RoleFilmService(RoleFilmRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public static void insertFilm() {
    }

    public Optional<RoleFilm> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public List<RoleFilm> getAllRoles() {
        return roleRepository.findAll();
    }

    public RoleFilm saveRole(RoleFilm role) {
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public List<RoleFilm> getRolesByFilm(Long filmId) {
        return null;
    }

    // Ajoutez d'autres méthodes au besoin
}
