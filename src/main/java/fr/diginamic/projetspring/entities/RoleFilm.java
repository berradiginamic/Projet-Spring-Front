package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;

/**
 * Représente le rôle d'un acteur dans un film, avec le personnage joué.
 */
@Entity
public class RoleFilm {

    /** Identifiant unique du rôle dans un film. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Personnage joué par l'acteur dans le film. */
    private String personnage;

    /** Acteur qui joue le rôle. */
    @ManyToOne
    @JoinColumn(name = "acteur_id")
    private Acteur acteur;

    /** Film dans lequel le rôle est joué. */
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    // Constructeurs

    /**
     * Constructeur par défaut.
     */
    public RoleFilm() {
    }

    /**
     * Constructeur avec acteur, film et personnage.
     *
     * @param acteur     L'acteur qui joue le rôle.
     * @param film       Le film dans lequel le rôle est joué.
     * @param personnage Le personnage joué par l'acteur dans le film.
     */
    public RoleFilm(Acteur acteur, Film film, String personnage) {
        this.acteur = acteur;
        this.film = film;
        this.personnage = personnage;
    }

    // Getters et Setters

    /**
     * Obtient l'identifiant unique du rôle dans un film.
     *
     * @return L'identifiant unique du rôle dans un film.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique du rôle dans un film.
     *
     * @param id L'identifiant unique du rôle dans un film.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient l'acteur qui joue le rôle.
     *
     * @return L'acteur qui joue le rôle.
     */
    public Acteur getActeur() {
        return acteur;
    }

    /**
     * Définit l'acteur qui joue le rôle.
     *
     * @param acteur L'acteur qui joue le rôle.
     */
    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    /**
     * Obtient le film dans lequel le rôle est joué.
     *
     * @return Le film dans lequel le rôle est joué.
     */
    public Film getFilm() {
        return film;
    }

    /**
     * Définit le film dans lequel le rôle est joué.
     *
     * @param film Le film dans lequel le rôle est joué.
     */
    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * Obtient le personnage joué par l'acteur dans le film.
     *
     * @return Le personnage joué par l'acteur dans le film.
     */
    public String getPersonnage() {
        return personnage;
    }

    /**
     * Définit le personnage joué par l'acteur dans le film.
     *
     * @param personnage Le personnage joué par l'acteur dans le film.
     */
    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }
}