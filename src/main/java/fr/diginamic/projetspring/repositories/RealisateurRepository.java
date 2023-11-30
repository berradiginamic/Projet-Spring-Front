package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {

    List<Realisateur> findByNomAndPrenom(String nom, String prenom);

    // Autres méthodes en fonction des besoins

    List<Realisateur> findByFilmsRealises_Titre(String titre);

}
