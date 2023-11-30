package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Rôle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RôleRepository extends JpaRepository<Rôle, Long> {

    List<Rôle> findByFilm_Titre(String titre);

    List<Rôle> findByActeur_Nom(String nom);

    List<Rôle> findByFilmId(Long filmId);

    // Autres méthodes en fonction des besoins
}
