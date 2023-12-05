package fr.diginamic.projetspring;


import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.entities.RoleFilm;
import fr.diginamic.projetspring.repositories.ActeurRepository;
import fr.diginamic.projetspring.repositories.FilmRepository;
import fr.diginamic.projetspring.services.ActeurService;
import fr.diginamic.projetspring.services.FilmService;
import fr.diginamic.projetspring.services.RealisateurService;
import fr.diginamic.projetspring.services.RoleFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class TraitementFichierApplication implements CommandLineRunner {

    @Autowired
    private ActeurService acteurService;
    @Autowired
    private RealisateurService realisateurService;
    @Autowired
    private RoleFilmService roleFilmService;
    @Autowired
    private FilmService filmService;// doit ajouter les autres services
    @Autowired
    private ActeurRepository acteurRepository;
    @Autowired
    private FilmRepository filmRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(TraitementFichierApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = app.run();
        TraitementFichierApplication traitementFichierApplication = context.getBean(TraitementFichierApplication.class);
        traitementFichierApplication.run();
    }



    /* Alimentation de la base de données à partir de fichiers CSV */
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d yyyy");
        // Set up a Set to track unique IDs
        Set<String> uniqueActeurIds = new HashSet<>();

        /** Import du fichier acteurs.csv */
        Path pathActeurs = Paths.get("C:/dev-java/acteurs.csv");
        try {
            List<String> rowsActeurs = Files.readAllLines(pathActeurs);
            rowsActeurs.remove(0);

            for (String rowActeur : rowsActeurs) {
                System.out.println(rowActeur);

                String[] elements = rowActeur.split(";");
                String idIMDB = elements[0].trim();
                // Vérification si l'ID existe déja
                if (!uniqueActeurIds.contains(idIMDB)) {
                    Acteur acteurs = new Acteur();
                    acteurs.setIdIMDB(idIMDB);
                    acteurs.setNom(elements[1]);
                    try {
                        Date dateNaissance = sdf.parse(elements[2]);
                        acteurs.setDateNaissance(dateNaissance);
                    } catch (ParseException e) {
                        // Handle the parsing exception appropriately
                    }
                    acteurs.setLieuNaissance(elements[3]);
                    acteurs.setUrlProfile(elements[5]);
                    // Sauvegarde de l'acteur dans la base de données
                    acteurService.createActeur(acteurs);
                    // Addition de Id dans le set de id unique
                    uniqueActeurIds.add(idIMDB);
                } else {
                    System.out.println("Duplicate ID: " + idIMDB);
                }
            }}
            catch (IOException e) {
                e.printStackTrace();
                // Handle the IO exception appropriately
            }

       /*  Import du fichier films.csv */
        Path pathFilms = Paths.get("C:/dev-java/films.csv");
        List<String> rowFilms = Files.readAllLines(pathFilms);
        rowFilms.remove(0);
        Set<String> uniqueFilmIds = new HashSet<>();
        for (String rowFilm : rowFilms) {
            System.out.println(rowFilm);
            String[] elements = rowFilm.split(";");
            String idIMDB = elements[0];
            // Vérification si l'ID existe déja
            if (!uniqueFilmIds.contains(idIMDB)) {
                Film films = new Film();
                films.setIdIMDB(idIMDB);
                films.setNom(elements[1]);
                // Handle anneeSortie
                if (elements.length >= 2) {
                    try {
                        films.setAnneeSortie(Integer.valueOf(elements[2]));
                    } catch (NumberFormatException e) {
                        System.out.println("Error converting film data: " + rowFilm);
                        e.printStackTrace();
                        continue;
                    }
                } else{
                        System.out.println("Année de sortie manquante");
                    }
                // Handle de resume
                if (elements.length >= 8) {
                    String resume = elements[8];
                    // Vérification de la longueur maximum d'un résumé
                    if (resume.length() > 255) {
                        // Truncate the resume to the maximum length
                        resume = resume.substring(0, 255);
                    }
                } else {
                    films.setResume("");
                }
                films.setRating(elements[3]);
                films.setUrlProfile(elements[4]);
                films.setLieuTournage(elements[5]);
                films.setGenres(elements[6]);
                films.setLangue(elements[7]);
                films.setPays(elements[9]);
                // ajout de l'id dans le set
                uniqueFilmIds.add(idIMDB);
                //sauvegarde de film dans la base de données
                filmService.createFilm(films);
            } else {
                System.out.println("Duplicate ID: " + idIMDB);
            }
        }

        /* Import du fichier realisateurs.csv */
        Path pathRealisateurs = Paths.get("C:/dev-java/realisateurs.csv");
        List<String> rowRealisateurs = Files.readAllLines(pathRealisateurs);
        rowRealisateurs.remove(0);
        for (String rowRealisateur : rowRealisateurs) {
            System.out.println(rowRealisateur);
            String[] elements = rowRealisateur.split(";");
            String idIMDB = elements[0];
            // Check if ID already exists
            if (!uniqueActeurIds.contains(idIMDB)) {
                // Create and save a new Film object
            Realisateur realisateurs = new Realisateur();
            realisateurs.setIdIMDB(idIMDB);
            realisateurs.setNom(elements[1]);
            try{
                Date dateNaissance = sdf.parse(elements[2]);
                realisateurs.setDateNaissance(dateNaissance);}
            catch (ParseException e) {
                // Handle the parsing exception appropriately
            }
            realisateurs.setLieuNaissance(elements[3]);
            realisateurs.setUrlProfile(elements[4]);

            // Save the film to the database
            realisateurService.createRealisateur(realisateurs);

            // Add ID to the unique IDs SetuniqueIds.add(idIMDB);
            } else {
                System.out.println("Duplicate ID: " + idIMDB);
        }
        }


    /** Import du fichier roles.csv
        Path pathRoleFilm = Paths.get("C:/dev-java/roles.csv");
        List<String> rowRoleFilm = Files.readAllLines(pathRoleFilm);
        rowRoleFilm.remove(0);
        for (String rowRoleFilms : rowRoleFilm) {
            System.out.println(rowRoleFilm);
            String[] elements = rowRoleFilms.split(";");
            Acteur acteur = acteurRepository.findById(Integer.parseInt(elements[0])).orElse(null);
            if (acteur == null) {
                System.out.println("Acteur with ID " + elements[0] + " not found");
                continue;
            }

            String filmId = elements[1];
            Film film = filmService.getFilmById(filmId); // Use the findByFilmId method to find the Film object
            if (film == null) {
                System.out.println("Film with ID " + filmId + " not found");
                continue;
            }
            RoleFilm role = new RoleFilm();
            role.setActeur(acteur);
            role.setFilm(film);
            role.setPersonnage(elements[2]);
            roleFilmService.createRoleFilm(role); */
        }
    }

