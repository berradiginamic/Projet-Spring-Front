package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface repository pour l'entité Film, utilisant Spring Data JPA.
 */
public interface FilmRepository extends JpaRepository<Film, Long> {


}
