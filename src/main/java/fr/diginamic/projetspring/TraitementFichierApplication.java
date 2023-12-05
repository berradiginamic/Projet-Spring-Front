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
import org.springframework.dao.DataIntegrityViolationException;

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
        Set<String> uniqueFilmIds = new HashSet<>();
        Set<String> uniqueRealisateursIds = new HashSet<>();

        /** Import du fichier acteurs.csv */
      /* Path pathActeurs = Paths.get("C:/dev-java/acteurs.csv");
        try {
            List<String> rowsActeurs = Files.readAllLines(pathActeurs);
            rowsActeurs.remove(0);
            for (String rowActeur : rowsActeurs) {
                System.out.println(rowActeur);
                String[] elements = rowActeur.split(";");
                String idIMDB = elements[0].trim();
                // Vérification si l'ID existe déjà
                if (!uniqueActeurIds.contains(idIMDB)) {
                    Acteur acteurs = new Acteur();
                    acteurs.setIdIMDB(idIMDB);
                    acteurs.setNom(elements[1]);
                    try {
                        Date dateNaissance = sdf.parse(elements[2]);
                        acteurs.setDateNaissance(dateNaissance);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        // Handle the parsing exception appropriately
                    }
                    acteurs.setLieuNaissance(elements[3]);
                    acteurs.setUrlProfile(elements[5]);
                    try {
                        // Attempt to save the Acteur entity
                        acteurService.createActeur(acteurs);
                        // Addition de l'ID dans le set d'ID uniques
                        uniqueActeurIds.add(idIMDB);
                    } catch (DataIntegrityViolationException e) {
                        // Handle the unique constraint violation
                        System.out.println("Duplicate ID: " + idIMDB);
                        // You might want to log the exception or take other actions
                    }
                } else {
                    System.out.println("Duplicate ID: " + idIMDB);
                }
            }
            System.out.println("Unique IDs Set: " + uniqueActeurIds);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the IO exception appropriately
        }
*/
        /*  Import du fichier films.csv */
    /*   Path pathFilms = Paths.get("C:/dev-java/films.csv");
        List<String> rowFilms = Files.readAllLines(pathFilms);
        rowFilms.remove(0);
        for (String rowFilm : rowFilms) {
            System.out.println(rowFilm);

            String[] elements = rowFilm.split(";");
            if (elements.length < 10) {
                System.out.println("Invalid data: " + rowFilm);
                continue;
            }

            String idIMDB = elements[0].trim();

            // Vérification si l'ID existe déjà
            if (!uniqueFilmIds.contains(idIMDB)) {
                Film films = new Film();
                films.setIdIMDB(idIMDB);
                films.setNom(elements[1]);

                // Handle anneeSortie
                if (elements.length >= 3) {
                    try {
                        films.setAnneeSortie(Integer.valueOf(elements[2]));
                    } catch (NumberFormatException e) {
                        System.out.println("Error converting film data: " + rowFilm);
                        e.printStackTrace();
                        continue;
                    }
                } else {
                    System.out.println("Année de sortie manquante");
                }
                // Handle resume
                if (elements.length >= 8) {
                    String resume = elements[8];
                    if (resume.length() > 255) {
                        resume = resume.substring(0, 255);
                    }
                    films.setResume(resume);
                } else {
                    films.setResume("");
                }
                films.setRating(elements[3]);
                films.setUrlProfile(elements[4]);
                films.setLieuTournage(elements[5]);
                films.setGenres(elements[6]);
                films.setLangue(elements[7]);
                films.setPays(elements[9]);
                try {
                    // Attempt to save the Film entity
                    filmService.createFilm(films);
                    // Addition de l'ID dans le set d'ID uniques
                    uniqueFilmIds.add(idIMDB);
                } catch (DataIntegrityViolationException e) {
                    // Handle the unique constraint violation
                    System.out.println("Duplicate ID: " + idIMDB);
                    // You might want to log the exception or take other actions
                }
            } else {
                System.out.println("Duplicate ID: " + idIMDB);
            }
        } */

        /* Import du fichier realisateurs.csv */
      /*Path pathRealisateurs = Paths.get("C:/dev-java/realisateurs.csv");
        List<String> rowRealisateurs = Files.readAllLines(pathRealisateurs);
        rowRealisateurs.remove(0);
        for (String rowRealisateur : rowRealisateurs) {
            System.out.println(rowRealisateur);
            String[] elements = rowRealisateur.split(";");
            String idIMDB = elements[0].trim();
            // Check if ID already exists
            if (!uniqueRealisateursIds.contains(idIMDB)) {
                // Create and save a new Film object
                Realisateur realisateurs = new Realisateur();
                realisateurs.setIdIMDB(idIMDB);
                realisateurs.setNom(elements[1]);
                try {
                    Date dateNaissance = sdf.parse(elements[2]);
                    realisateurs.setDateNaissance(dateNaissance);
                } catch (ParseException e) {
                    // Handle the parsing exception appropriately
                }
                realisateurs.setLieuNaissance(elements[3]);
                realisateurs.setUrlProfile(elements[4]);
                try {
                    // Save the film to the database
                    realisateurService.createRealisateur(realisateurs);
                    // trynnnnnn
                    uniqueRealisateursIds.add(idIMDB);
                } catch (DataIntegrityViolationException e) {
                    // Handle the unique constraint violation
                    System.out.println("Duplicate ID: " + idIMDB);
                    // You might want to log the exception or take other actions
                }


                // Add ID to the unique IDs SetuniqueIds.add(idIMDB);
            } else {
                System.out.println("Duplicate ID: " + idIMDB);
            }
        } */



        /** Import du fichier roles.csv */
        Path pathRoleFilm = Paths.get("C:/dev-java/roles.csv");
        List<String> rowRoleFilm = Files.readAllLines(pathRoleFilm);
        rowRoleFilm.remove(0);

        for (String rowRoleFilms : rowRoleFilm) {
            System.out.println(rowRoleFilm);

            String[] elements = rowRoleFilms.split(";");
            String acteurIdIMDB = elements[1].trim();
            String filmIdIMDB = elements[0].trim();
            Acteur acteur = acteurService.findByIdIMDB(acteurIdIMDB);
            Film film = filmService.findByIdIMDB(filmIdIMDB);

            if (acteur != null && film != null) {
                // Create and save a new Role entity
                RoleFilm role = new RoleFilm();

                role.setActeurId(acteur.getActeurId());
                role.setFilmId(film.getFilmId());
                if (acteur.getActeurId() != null) {
                    role.setActeurId(acteur.getActeurId());
                } else {
                    System.out.println("Acteur ID is null for IDIMDB: " + acteurIdIMDB);
                    continue; // Skip the current iteration if Acteur ID is null
                }

                // Check if Film ID is not null before setting it
                if (film.getFilmId() != null) {
                    role.setFilmId(film.getFilmId());
                } else {
                    System.out.println("Film ID is null for IDIMDB: " + filmIdIMDB);
                    continue; // Skip the current iteration if Film ID is null
                }

                role.setPersonnage(elements[2]); // Set the correct value for personnage
                roleFilmService.createRoleFilm(role);
            }
        }
    }}

