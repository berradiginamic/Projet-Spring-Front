package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    // Exemple : Enregistrer un nouveau genre
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    // Exemple : Supprimer un genre par son identifiant
    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }
}
