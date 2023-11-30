package fr.diginamic.projetspring;

import fr.diginamic.projetspring.entities.Realisateur;
import fr.diginamic.projetspring.services.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class TraitementFichiersApplication implements CommandLineRunner {

	@Autowired
	private RealisateurService realisateurService;

	public static void main(String[] args) {
		SpringApplication.run(TraitementFichiersApplication.class, args);
	}


/* Alimentation de la base de données à partir de fichiers CSV */
	@Override
	public void run(String... args) throws Exception {
		Path pathRealisateurs = Paths.get("C:/dev-java/realisateurs.csv");  // Import realisateurs.csv
		List<String> rowRealisateurs = Files.readAllLines(pathRealisateurs);
		rowRealisateurs.remove(0);
		for (String rowRealisateur : rowRealisateurs){
			System.out.println(rowRealisateur);
			String[] elements = rowRealisateur.split(";");
			Realisateur realisateurs = new Realisateur();
			realisateurs.setNom(elements[1]);
			realisateurs.setDateNaissance(elements[2]);
			realisateurs.setLieuNaissance(elements[3]);
			realisateurs.setURLProfile(elements[4]);
			realisateurService.saveRealisateur(realisateurs);
		}
	}
}
