package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.repositories.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RealisateurService {

    private final RealisateurRepository realisateurRepository;

    @Autowired
    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }

    public List<Realisateur> getAllRealisateurs() {
        return realisateurRepository.findAll();
    }

    public Optional<Realisateur> getRealisateurById(Long id) {
        return realisateurRepository.findById(id);
    }

    public Realisateur saveRealisateur(Realisateur realisateur) {
        return realisateurRepository.save(realisateur);
    }

    public void deleteRealisateurById(Long id) {
        realisateurRepository.deleteById(id);
    }
    // Ajoutez d'autres méthodes au besoin
}
