package fr.diginamic.projetspring.repositories;

import fr.diginamic.projetspring.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    // Ajoutez des méthodes spécifiques au besoin

    // Exemple: Recherche de genre par nom
    Genre findByName(String name);
}
