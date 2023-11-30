package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByTitreContainingIgnoreCase(String titre);

    List<Film> findByAnneeSortieBetween(int debut, int fin);

    // Autres méthodes en fonction des besoins

    List<Film> findByActeurs_Nom(String nom);

    List<Film> findByActeurs_NomAndActeurs_Prenom(String nom, String prenom);

    List<Film> findByGenres_Nom(String genre);

    List<Film> findByActeurs_NomAndGenres_Nom(String nomActeur, String nomGenre);

    List<Film> findByRealisateur_Nom(String nom);

}
