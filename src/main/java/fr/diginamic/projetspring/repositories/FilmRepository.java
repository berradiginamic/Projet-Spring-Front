package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface repository pour l'entité Film, utilisant Spring Data JPA.
 */
public interface FilmRepository extends JpaRepository<Film, Long> {

    /**
     * Méthode héritée de JpaRepository pour rechercher tous les films.
     *
     * @return Une liste de tous les films.
     */
    List<Film> findAll();

    // Ajoutez d'autres méthodes déclaratives en fonction des besoins

}
