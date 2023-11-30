package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;

@Entity
public class RoleFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "acteur_id")
    private Acteur acteur;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    private String roleName;

    // Constructeurs

    public RoleFilm() {
    }

    public RoleFilm(Acteur acteur, Film film, String roleName) {
        this.acteur = acteur;
        this.film = film;
        this.roleName = roleName;
    }

    public static void setNom(String element) {
    }

    public static void setDateNaissance(String element) {
    }

    public static void setLieuNaissance(String element) {
    }

    public static void setURLProfile(String element) {
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
