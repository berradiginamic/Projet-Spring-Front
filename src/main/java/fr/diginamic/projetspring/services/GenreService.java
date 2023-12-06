package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service gérant les opérations liées à l'entité Genre.
 */
@Service
public class GenreService {
    /**
     * Constructeur du service Genre.
     *
     * @param genreRepository Le repository pour les opérations liées à l'entité Genre.
     */
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    public Genre findById(Integer genreId) {
        return genreRepository.findById(genreId).orElse(null);
    }

    /**
     * Enregistre un nouveau genre dans la base de données.
     *
     * @param genre Le genre à enregistrer.
     * @return Le genre enregistré.
     */
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    /**
     * Supprime un genre par son identifiant.
     *
     * @param genreId L'identifiant du genre à supprimer.
     */
    public void deleteGenre(Integer genreId) {
        genreRepository.deleteById(genreId);}

    public List<Genre> findByName(String name) {
        return genreRepository.findAllByName(name);
    }

    public Genre findOrCreateGenreByName(String name) {
        // Check if the genre with the given name already exists
        Optional<Genre> existingGenre = genreRepository.findByName(name);

        if (existingGenre.isPresent()) {
            // If the genre exists, return it
            return existingGenre.get();
        } else {
            // If the genre does not exist, create a new one and save it
            Genre newGenre = new Genre();
            newGenre.setName(name);
            return genreRepository.save(newGenre);
        }
    }
}
