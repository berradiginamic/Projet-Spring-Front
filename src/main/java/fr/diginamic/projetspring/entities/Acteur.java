package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Représente un acteur participant à des films.
 */
@Entity
public class Acteur {

    /** Identifiant unique de l'acteur. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nom de l'acteur. */
    private String nom;
    private Date dateNaissance;
    private String LieuNaissance;
    private String urlProfile;

    /** Film dans lequel l'acteur a joué. */
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;


    /** Liste des rôles que l'acteur a joués dans des films. */
    @OneToMany(mappedBy = "acteur")
    private List<RoleFilm> roles;

    // Constructeurs
    /**
     * Constructeur par défaut.
     */
    public Acteur() {
    }


    /**
     * Constructeur avec nom, prénom et film dans lequel l'acteur a joué.
     *
     * @param nom    Nom de l'acteur.
     * @param film   Film dans lequel l'acteur a joué.
     */
    public Acteur(String nom, Film film) {
        this.nom = nom;
        this.film = film;
    }

    // Getters et setters

    /**
     * Obtient l'identifiant unique de l'acteur.
     *
     * @return L'identifiant unique de l'acteur.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique de l'acteur.
     *
     * @param id L'identifiant unique de l'acteur.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient le nom de l'acteur.
     *
     * @return Le nom de l'acteur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'acteur.
     *
     * @param nom Le nom de l'acteur.
     */
    public void setNom(String nom) {
        this.nom = nom;
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

    /**
     * Obtient le film dans lequel l'acteur a joué.
     *
     * @return Le film dans lequel l'acteur a joué.
     */
    public Film getFilm() {
        return film;
    }


    /**
     * Définit le film dans lequel l'acteur a joué.
     *
     * @param film Le film dans lequel l'acteur a joué.
     */
    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * Obtient la liste des rôles que l'acteur a joués dans des films.
     *
     * @return La liste des rôles que l'acteur a joués.
     */
    public List<RoleFilm> getRoles() {
        return roles;
    }


    /**
     * Obtient la date de naissance de l'acteur.
     *
     * @return La date de naissance de l'acteur.
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Définit la date de naissance de l'acteur.
     *
     * @param dateNaissance La date de naissance de l'acteur.
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // Autres méthodes
    // (Ajoutez ici d'autres méthodes pertinentes avec des commentaires JavaDoc)

    /**
     * Insère un acteur dans la base de données.
     *
     * @param acteur L'acteur à insérer.
     */
    public void insertActeur(Acteur acteur) {
        // Logique pour insérer l'acteur dans la base de données.
    }
}