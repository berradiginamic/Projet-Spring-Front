package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Interface repository pour l'entité Acteur, utilisant Spring Data JPA.
 */
public interface ActeurRepository extends JpaRepository<Acteur, Integer> {
    // Find all actors by name

    List<Acteur> findAllByNom(String nom);

    // Find all actors by lieu de naissance
    List<Acteur> findAllByLieuNaissance(String lieuNaissance);

    // Find all actors by date de naissance
    List<Acteur> findAllByDateNaissance(Date dateNaissance);

    // Find all actors by URL profile
    List<Acteur> findAllByUrlProfile(String urlProfile);
}

