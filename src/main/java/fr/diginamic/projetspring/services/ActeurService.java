package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Rôle;
import fr.diginamic.projetspring.repositories.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActeurService {

    @Autowired
    private ActeurRepository acteurRepository;

    public List<Acteur> getAllActeurs() {
        return acteurRepository.findAll();
    }

    public Optional<Acteur> getActeurById(Long id) {
        return acteurRepository.findById(id);
    }

    public Acteur saveActeur(Acteur acteur) {
        return acteurRepository.save(acteur);
    }

    public void deleteActeur(Long id) {
        acteurRepository.deleteById(id);
    }

    public List<Film> getFilmsByActeur(Long acteurId) {
        Optional<Acteur> acteur = acteurRepository.findById(acteurId);
        return acteur.map(Acteur::getRoles)
                .orElse(Collections.emptyList())
                .stream()
                .map(Rôle::getFilm)
                .collect(Collectors.toList());
    }

    public List<Rôle> getRolesByActeur(Long acteurId) {
        Optional<Acteur> acteur = acteurRepository.findById(acteurId);
        return (List<Rôle>) acteur.map(Acteur::getRoles)
                .orElse(Collections.emptyList());
    }
    // Autres méthodes en fonction des besoins
}
