package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service gérant les opérations liées à l'entité Genre.
 */
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    /**
     * Constructeur du service Genre.
     *
     * @param genreRepository Le repository pour les opérations liées à l'entité Genre.
     */
    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    /**
     * Enregistre un nouveau genre dans la base de données.
     *
     * @param genre Le genre à enregistrer.
     * @return Le genre enregistré.
     */
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    /**
     * Supprime un genre par son identifiant.
     *
     * @param id L'identifiant du genre à supprimer.
     */
    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }
}
