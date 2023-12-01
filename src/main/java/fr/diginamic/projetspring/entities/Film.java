package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private LocalDate anneeSortie;
    private Double rating;
    private String urlProfile;
    private String lieuTournage;
    private String langue;
    private String resume;
    private String pays;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    @OneToMany(mappedBy = "film")
    private List<Acteur> acteurs;

    // Constructeurs
    public Film() {
    }

    public Film(String nom, Realisateur realisateur, List<Acteur> acteurs) {
        this.nom = nom;
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

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getAnneeSortie() {
        return anneeSortie;
    }
    public void setAnneeSortie(LocalDate anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getUrlProfile() {
        return urlProfile;
    }

    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public String getLieuTournage() {
        return lieuTournage;
    }

    public void setLieuTournage(String lieuTournage) {
        this.lieuTournage = lieuTournage;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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
}
