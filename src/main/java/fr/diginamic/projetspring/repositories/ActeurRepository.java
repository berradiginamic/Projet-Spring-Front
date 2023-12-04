package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface repository pour l'entité Acteur, utilisant Spring Data JPA.
 */
public interface ActeurRepository extends JpaRepository<Acteur, Long> {
}

