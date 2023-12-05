package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Représente un réalisateur avec ses informations personnelles et la liste des films qu'il a réalisés.
 */
@Entity
@Table(name= "realisateurs")
public class Realisateur {

    /** Identifiant unique du réalisateur. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRealisateur;

    /** Identifiant imdb du réalisateur. */
    private String idIMDB;
    /** Nom du réalisateur. */
    private String nom;
    /** Date de naissance du réalisateur. */
    private Date dateNaissance;
    /** Lieu de naissance du réalisateur. */
    private String lieuNaissance;
    /** URL du profil du réalisateur. */
    private String urlProfile;

    /** Liste des films réalisés par le réalisateur. */
    @OneToMany(mappedBy = "realisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Film> film;

    // Constructeurs
    /**
     * Constructeur par défaut.
     */
    public Realisateur() {
    }

    /**
     * Constructeur avec nom du réalisateur.
     *
     * @param nom Le nom du réalisateur.
     */
    public Realisateur(String idIMDB, String lieuNaissance, Date dateNaissance, String nom, String urlProfile) {
        this.idRealisateur = Integer.parseInt(idIMDB);
        this.lieuNaissance = lieuNaissance;
        this.dateNaissance = dateNaissance;
        this.nom = nom;
        this.urlProfile = urlProfile;
    }

    // Getters et Setters

    /**
     * Obtient l'identifiant unique du réalisateur.
     *
     * @return L'identifiant unique du réalisateur.
     */
    public Integer getIdRealisateur() {
        return idRealisateur;
    }

    /**
     * Définit l'identifiant unique du réalisateur.
     *
     * @param idRealisateur L'identifiant unique du réalisateur.
     */
    public void setIdRealisateur(Integer idRealisateur) {
        this.idRealisateur = idRealisateur;
    }

    public String getIdIMDB() {
        return idIMDB;
    }

    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
    }

    /**
     * Obtient le nom du réalisateur.
     *
     * @return Le nom du réalisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du réalisateur.
     *
     * @param nom Le nom du réalisateur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient la date de naissance du réalisateur.
     *
     * @return La date de naissance du réalisateur.
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Définit la date de naissance du réalisateur.
     *
     * @param dateNaissance La date de naissance du réalisateur.
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Obtient le lieu de naissance du réalisateur.
     *
     * @return Le lieu de naissance du réalisateur.
     */
    public String getLieuNaissance() {
        return lieuNaissance;
    }

    /**
     * Définit le lieu de naissance du réalisateur.
     *
     * @param lieuNaissance Le lieu de naissance du réalisateur.
     */
    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    /**
     * Obtient l'URL du profil du réalisateur.
     *
     * @return L'URL du profil du réalisateur.
     */
    public String getUrlProfile() {
        return urlProfile;
    }

    /**
     * Définit l'URL du profil du réalisateur.
     *
     * @param urlProfile L'URL du profil du réalisateur.
     */
    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    /**
     * Obtient la liste des films réalisés par le réalisateur.
     *
     * @return La liste des films réalisés par le réalisateur.
     */
    public List<Film> getFilm() {
        return film;
    }

    /**
     * Définit la liste des films réalisés par le réalisateur.
     *
     * @param film La liste des films réalisés par le réalisateur.
     */
    public void setFilm(List<Film> film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Realisateur{" + "idRealisateur=" + idRealisateur + ", lieuNaissance='" + lieuNaissance + '\''
                + ", dateNaissance=" + dateNaissance + ", nom='" + nom + '\''
                + ", urlProfile='" + urlProfile + '\'' + ", films=" + film + '}';
    }
}
