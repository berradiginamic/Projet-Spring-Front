package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Interface repository pour l'entité Film, utilisant Spring Data JPA.
 */
public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findByGenresContainingIgnoreCase(String genreType);

        List<Film> findByGenresTypeIgnoreCase(String genreType);


    // Find all films by annee de sortie
    List<Film> findAllByAnneeSortie(Integer anneeSortie);

    // Find all films by langue
    List<Film> findAllByLangue(String langue);

    // Find all films by lieu de tournage
    List<Film> findAllByLieuTournage(String lieuTournage);

    // Find all films by réalisateur nom
    List<Film> findAllByNom(String nom);

    // Find all films by pays
    List<Film> findAllByPays(String pays);

    // Find all films by rating
    List<Film> findAllByRating(String rating);

    // Find all films by resume
    List<Film> findAllByResume(String resume);

    // Find all films by URL profile
    List<Film> findAllByUrlProfile(String urlProfile);

    // Find all films by genre
    List<Film> findAllByGenresIn(Set<Genre> genres);

    // Find all films by realisateur id
   /* @Query("SELECT f FROM Film f JOIN f.realisateur r WHERE r.idRealisateur = :realisateurId")
    List<Film> findAllByRealisateurId(@Param("realisateurId") Integer realisateurId); */

    Film findByIdIMDB(String idIMDB);

    List<Film> findByGenres_Type(String genreType);
}
