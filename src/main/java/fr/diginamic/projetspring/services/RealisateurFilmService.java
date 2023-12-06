package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.entities.RealisateurFilm;
import fr.diginamic.projetspring.repositories.RealisateurFilmRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealisateurFilmService {
    @Autowired
    private RealisateurFilmRepository realisateurFilmRepository;
    @Autowired
    private RealisateurService realisateurService;
    @Autowired
    private FilmService filmService;

    @Transactional
    public RealisateurFilm createRealisateurFilm(RealisateurFilm realisateurFilm) {
        Realisateur realisateur = realisateurService.findByIdIMDB(realisateurFilm.getRealisateur().getIdIMDB());
        Film film = filmService.findByIdIMDB(realisateurFilm.getFilm().getIdIMDB());
        realisateurFilm.setRealisateur(realisateur);
        realisateurFilm.setFilm(film);
        return realisateurFilmRepository.save(realisateurFilm);
    }
}
