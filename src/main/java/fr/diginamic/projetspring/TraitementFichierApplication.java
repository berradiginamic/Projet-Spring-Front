package fr.diginamic.projetspring;


import fr.diginamic.projetspring.entities.Acteur;
import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.entities.RoleFilm;
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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

        /** Import du fichier acteurs.csv */
        Path pathActeurs = Paths.get("C:/dev-java/acteurs.csv");
        List<String> rowsActeurs = Files.readAllLines(pathActeurs);
        rowsActeurs.remove(0);
        for (String rowActeur : rowsActeurs) {
            System.out.println(rowActeur);
            String[] elements = rowActeur.split(";");
            Acteur acteurs = new Acteur();
            acteurs.setActeur_id(elements[0]);
            acteurs.setNom(elements[1]);
            try{
            Date dateNaissance = sdf.parse(elements[2]);
            acteurs.setDateNaissance(dateNaissance);}
            catch (ParseException e) {
                // Handle the parsing exception appropriately
            }
            acteurs.setLieuNaissance(elements[3]);
            acteurs.setUrlProfile(elements[5]);
            acteurService.saveActeur(acteurs);
        }

        /** Import du fichier films.csv */
        Path pathFilms = Paths.get("C:/dev-java/films.csv");
        List<String> rowFilms = Files.readAllLines(pathFilms);
        rowFilms.remove(0);
        for (String rowFilm : rowFilms) {
            System.out.println(rowFilm);
            String[] elements = rowFilm.split(";");
            Film films = new Film();

            films.setNom(elements[1]);
            try{
                Date anneeSortie = sdf.parse(elements[2]);
                films.setAnneeSortie(anneeSortie);}
            catch (ParseException e) {
                // Handle the parsing exception appropriately
            }
            films.setRating(elements[3]);
            films.setUrlProfile(elements[4]);
            films.setLieuTournage(elements[5]);
            films.setGenres(elements[6]);
            films.setLangue(elements[7]);
            /* films.setResume(elements[8]); cause une erreure de chaines trop longues */
            films.setPays(elements[9]);
            filmService.saveFilm(films);
        }

        /** Import du fichier realisateurs.csv */
        Path pathRealisateurs = Paths.get("C:/dev-java/realisateurs.csv");
        List<String> rowRealisateurs = Files.readAllLines(pathRealisateurs);
        rowRealisateurs.remove(0);
        for (String rowRealisateur : rowRealisateurs) {
            System.out.println(rowRealisateur);
            String[] elements = rowRealisateur.split(";");
            Realisateur realisateurs = new Realisateur();
            realisateurs.setRealisateur_id(elements[0]);
            realisateurs.setNom(elements[1]);
            try{
                Date dateNaissance = sdf.parse(elements[2]);
                realisateurs.setDateNaissance(dateNaissance);}
            catch (ParseException e) {
                // Handle the parsing exception appropriately
            }
            realisateurs.setLieuNaissance(elements[3]);
            realisateurs.setUrlProfile(elements[4]);
            realisateurService.saveRealisateur(realisateurs);
        }

    /** Import du fichier roles.csv */
        Path pathRoleFilm = Paths.get("C:/dev-java/roles.csv");
        List<String> rowRoleFilm = Files.readAllLines(pathRoleFilm);
        rowRoleFilm.remove(0);
        for (String rowRoleFilms : rowRoleFilm) {
            System.out.println(rowRoleFilm);
            String[] elements = rowRoleFilms.split(";");
            RoleFilm role = new RoleFilm();

            role.setPersonnage(elements[2]);
            roleFilmService.saveRoleFilm(role);
        }
    }
}
