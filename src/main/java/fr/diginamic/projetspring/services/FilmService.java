package fr.diginamic.projetspring.services;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final ActeurRepository acteurRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository, ActeurRepository acteurRepository, RoleRepository roleRepository) {
        this.filmRepository = filmRepository;
        this.acteurRepository = acteurRepository;
        this.roleRepository = roleRepository;
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    public Optional<Film> updateFilm(Long id, Film updatedFilm) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (optionalFilm.isPresent()) {
            Film existingFilm = optionalFilm.get();
            // Mettez à jour les propriétés du film existant avec les valeurs de updatedFilm
            // ...
            return Optional.of(filmRepository.save(existingFilm));
        }
        return Optional.empty();
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    public List<Film> getFilmsByActeur(Long acteurId) {
        Optional<Acteur> optionalActeur = acteurRepository.findById(acteurId);
        if (optionalActeur.isPresent()) {
            Acteur acteur = optionalActeur.get();
            return roleRepository.findByActeur(acteur)
                    .stream()
                    .map(Role::getFilm)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    // Ajoutez d'autres méthodes selon vos besoins
}
