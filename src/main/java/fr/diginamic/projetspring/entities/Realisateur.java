package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String lieuNaissance;
    private String URLProfile;

    // Constructeurs
    public Realisateur() {
    }

    public Realisateur(String nom) {
        this.nom = nom;
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

    public void setDateNaissance(String dateNaissance) {
    }

    getD==

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setURLProfile(String urlProfile) {
        this.URLProfile = urlProfile;
    }

    public String getURLProfile() {
        return URLProfile;
    }

    public void insertFilm(Realisateur realisateurs) {
    }
}
