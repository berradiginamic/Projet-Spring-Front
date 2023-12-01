package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface repository pour l'entité Genre, utilisant Spring Data JPA.
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // Aucune méthode spécifique déclarée ici, car JpaRepository offre déjà des méthodes génériques pour les opérations CRUD.

    // Ajoutez d'autres méthodes déclaratives en fonction des besoins

}
