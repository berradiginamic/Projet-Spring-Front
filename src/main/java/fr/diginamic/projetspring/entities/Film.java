package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    @OneToMany(mappedBy = "film")
    private List<Acteur> acteurs;

    // Constructeurs
    public Film() {
    }

    public Film(String titre, Realisateur realisateur, List<Acteur> acteurs) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setNom(String element) {
    }

    public void setAnneeSortie(String element) {
    }

    public void setAvis(String element) {
    }

    public void setLieuTournage(String element) {
    }

    public void setGenres(String element) {
    }

    public void setLangues(String element) {
    }

    public void setResume(String element) {
    }

    public void setPays(String element) {
    }
}
