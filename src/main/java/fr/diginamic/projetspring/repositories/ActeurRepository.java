package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface repository pour l'entité Acteur, utilisant Spring Data JPA.
 */
public interface ActeurRepository extends JpaRepository<Acteur, Long> {

    /**
     * Recherche les acteurs ayant le nom spécifié.
     *
     * @param nom Le nom de l'acteur à rechercher.
     * @return Une liste d'acteurs ayant le nom spécifié.
     */
    List<Acteur> findByNom(String nom);

    /**
     * Recherche les acteurs ayant le prénom spécifié.
     *
     * @param prenom Le prénom de l'acteur à rechercher.
     * @return Une liste d'acteurs ayant le prénom spécifié.
     */
    List<Acteur> findByPrenom(String prenom);

    // Ajoutez d'autres méthodes déclaratives en fonction des besoins

}
