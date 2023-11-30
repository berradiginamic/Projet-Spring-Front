package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.repositories.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActeurService {

    private final ActeurRepository acteurRepository;


    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public List<Acteur> getAllActeurs() {
        return acteurRepository.findAll();
    }

    public Acteur getActeurById(Long id) {
        return acteurRepository.findById(id).orElse(null);
    }

    public Acteur createActeur(Acteur acteur) {
        // Logique de création de l'acteur (par exemple, validation des données, etc.)
        return acteurRepository.save(acteur);
    }

    public Acteur updateActeur(Long id, Acteur acteur) {
        // Logique de mise à jour de l'acteur (par exemple, vérification de l'existence de l'acteur, validation des données, etc.)
        if (acteurRepository.existsById(id)) {
            acteur.setId(id);
            return acteurRepository.save(acteur);
        }
        return null; // Ou lancez une exception appropriée si nécessaire
    }

    public void deleteActeur(Long id) {
        acteurRepository.deleteById(id);
    }
}
