package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private LocalDate dateNaissance;
    private String LieuNaissance;
    private String urlProfile;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @OneToMany(mappedBy = "acteur")
    private List<RoleFilm> roles;

    // Constructeurs
    public Acteur() {
    }

    public Acteur(String nom, Film film) {
        this.nom = nom;
        this.film = film;
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    public String getLieuNaissance() {
        return LieuNaissance;
    }
    public void setLieuNaissance(String lieuNaissance) {
        LieuNaissance = lieuNaissance;
    }

    public String getUrlProfile() {
        return urlProfile;
    }
    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public Film getFilm() {
        return film;
    }
    public void setFilm(Film film) {
        this.film = film;
    }

    public List<RoleFilm> getRoles() {
        return roles;
    }

}