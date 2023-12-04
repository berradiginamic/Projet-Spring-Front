package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface repository pour l'entité Réalisateur, utilisant Spring Data JPA.
 */
public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {

    // Aucune méthode spécifique déclarée ici, car JpaRepository offre déjà des méthodes génériques pour les opérations CRUD.

    // Ajoutez d'autres méthodes déclaratives en fonction des besoins

}
