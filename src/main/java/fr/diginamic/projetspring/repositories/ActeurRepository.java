package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ActeurRepository extends JpaRepository<Acteur, Long> {

    List<Acteur> findByNom(String nom);

    List<Acteur> findByPrenom(String prenom);


    // Autres méthodes en fonction des besoins
}