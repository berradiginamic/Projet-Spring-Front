package fr.diginamic.projetspring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByTitreContainingIgnoreCase(String titre);

    List<Film> findByAnneeSortieBetween(int startYear, int endYear);

    List<Film> findByActeurs(Acteur acteur);

    List<Film> findByGenres(Genre genre);

    List<Film> findByRealisateur(Realisateur realisateur);

    // Vous pouvez ajouter d'autres méthodes en fonction des besoins
}
