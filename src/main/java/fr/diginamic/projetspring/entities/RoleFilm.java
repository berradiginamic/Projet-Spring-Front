package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;

/**
 * Représente le rôle d'un acteur dans un film, avec le personnage joué.
 */
@Entity
@Table(name = "rolefilm")
public class RoleFilm {

    /** Identifiant unique du rôle dans un film. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    /** Personnage joué par l'acteur dans le film. */
    @Column(name="personnage")
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
     *  acteur     L'acteur qui joue le rôle.
     *  film       Le film dans lequel le rôle est joué.
     * @param personnage Le personnage joué par l'acteur dans le film.
     */
    public RoleFilm(String personnage, Film film, Acteur acteur) {
        this.personnage = personnage;
        this.film = film;
        this.acteur = acteur;
    }

    // Getters et Setters

    /**
     * Obtient l'identifiant unique du rôle dans un film.
     *
     * @return L'identifiant unique du rôle dans un film.
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Définit l'identifiant unique du rôle dans un film.
     *
     * @param roleId L'identifiant unique du rôle dans un film.
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    @Override
    public String toString() {
        return "Role{" + "roleId=" + roleId + ", personnage='" + personnage + '\'' + '}';
    }
}