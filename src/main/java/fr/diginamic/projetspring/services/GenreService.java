package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    // Ajoutez des méthodes de service au besoin

    // Exemple : Récupérer tous les genres
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    // Exemple : Récupérer un genre par son nom
    public Genre getGenreByName(String name) {
        return genreRepository.findByName(name);
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
