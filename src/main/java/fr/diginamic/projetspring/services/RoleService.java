package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Rôle;
import fr.diginamic.projetspring.repositories.RôleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RôleRepository roleRepository;

    @Autowired
    public RoleService(RôleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Rôle> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public List<Rôle> getAllRoles() {
        return roleRepository.findAll();
    }

    public Rôle saveRole(Rôle role) {
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public List<Rôle> getRolesByFilm(Long filmId) {
        return null;
    }

    // Ajoutez d'autres méthodes au besoin
}
