package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ActeurRepository extends JpaRepository<Acteur, Long> {

    List<Acteur> findByNom(String nom);

    List<Acteur> findByPrenom(String prenom);

    List<Acteur> findByDateNaissanceBefore(Date date);

    // Autres méthodes en fonction des besoins

    List<Acteur> findByGenres_Nom(String genre);

    List<Acteur> findByRoles_Film_Titre(String titre);

    List<Acteur> findByRoles_Film_AnneeSortieBetween(int debut, int fin);

    List<Acteur> findByRoles_Film_Acteurs_Nom(String nom);

    List<Acteur> findByRoles_Film_Realisateur_Nom(String nom);

    List<Acteur> findByRoles_Film_AnneeSortieBetweenAndRoles_Film_Acteurs_Nom(int debut, int fin, String nom);

    List<Acteur> findByRoles_Film_Acteurs_Genres_NomOrderByCountDesc(String genre);

}
