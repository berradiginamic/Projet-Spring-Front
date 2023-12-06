package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.entities.RealisateurFilm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Interface repository pour l'entité Réalisateur, utilisant Spring Data JPA.
 */
public interface RealisateurFilmRepository extends JpaRepository<RealisateurFilm, Integer> {

}
