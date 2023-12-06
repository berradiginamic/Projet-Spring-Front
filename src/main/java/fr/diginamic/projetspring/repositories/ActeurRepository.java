package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    Acteur findByIdIMDB(String idIMDB);

    /** Création des requetes pour les extractions */
    // Implementation des Queries pour les extractions:
    // Tache 1: Extraire tous les films (nom et années de sortie) d’un acteur donné
    @Query("SELECT f.nom AS film_nom, f.anneeSortie " +
            "FROM Acteur a " +
            "JOIN RoleFilm r ON a.acteurId = r.acteur.acteurId " +
            "JOIN Film f ON r.film.filmId = f.filmId " +
            "WHERE a.acteurId = :acteurId")
    List<Object[]> findFilmsByActeurId(@Param("acteurId") Integer acteurId);
}

