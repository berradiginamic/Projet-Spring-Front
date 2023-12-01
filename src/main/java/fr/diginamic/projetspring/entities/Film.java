package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Représente un film avec ses caractéristiques et les personnes impliquées dans sa création.
 */
@Entity
public class Film {

    /** Identifiant unique du film. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nom du film. */
    private String nom;

    /** Date de sortie du film. */
    private LocalDate anneeSortie;

    /** Note du film. */
    private Double rating;

    /** URL du profil du film. */
    private String urlProfile;

    /** Lieu de tournage du film. */
    private String lieuTournage;

    /** Langue du film. */
    private String langue;

    /** Résumé du film. */
    private String resume;

    /** Pays d'origine du film. */
    private String pays;

    /** Réalisateur du film. */
    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    /** Liste des acteurs qui ont joué dans le film. */
    @OneToMany(mappedBy = "film")
    private List<Acteur> acteurs;

    // Constructeurs
    /**
     * Constructeur par défaut.
     */
    public Film() {
    }

    /**
     * Constructeur avec nom, réalisateur et liste d'acteurs.
     *
     * @param nom       Nom du film.
     * @param realisateur Réalisateur du film.
     * @param acteurs   Liste des acteurs qui ont joué dans le film.
     */
    public Film(String nom, Realisateur realisateur, List<Acteur> acteurs) {
        this.nom = nom;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
    }

    // Getters et setters

    /**
     * Obtient l'identifiant unique du film.
     *
     * @return L'identifiant unique du film.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique du film.
     *
     * @param id L'identifiant unique du film.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient le nom du film.
     *
     * @return Le nom du film.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du film.
     *
     * @param nom Le nom du film.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient la date de sortie du film.
     *
     * @return La date de sortie du film.
     */
    public LocalDate getAnneeSortie() {
        return anneeSortie;
    }

    /**
     * Définit la date de sortie du film.
     *
     * @param anneeSortie La date de sortie du film.
     */
    public void setAnneeSortie(LocalDate anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    /**
     * Obtient la note du film.
     *
     * @return La note du film.
     */
    public Double getRating() {
        return rating;
    }

    /**
     * Définit la note du film.
     *
     * @param rating La note du film.
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * Obtient l'URL du profil du film.
     *
     * @return L'URL du profil du film.
     */
    public String getUrlProfile() {
        return urlProfile;
    }

    /**
     * Définit l'URL du profil du film.
     *
     * @param urlProfile L'URL du profil du film.
     */
    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    /**
     * Obtient le lieu de tournage du film.
     *
     * @return Le lieu de tournage du film.
     */
    public String getLieuTournage() {
        return lieuTournage;
    }

    /**
     * Définit le lieu de tournage du film.
     *
     * @param lieuTournage Le lieu de tournage du film.
     */
    public void setLieuTournage(String lieuTournage) {
        this.lieuTournage = lieuTournage;
    }

    /**
     * Obtient la langue du film.
     *
     * @return La langue du film.
     */
    public String getLangue() {
        return langue;
    }

    /**
     * Définit la langue du film.
     *
     * @param langue La langue du film.
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }

    /**
     * Obtient le résumé du film.
     *
     * @return Le résumé du film.
     */
    public String getResume() {
        return resume;
    }

    /**
     * Définit le résumé du film.
     *
     * @param resume Le résumé du film.
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     * Obtient le pays d'origine du film.
     *
     * @return Le pays d'origine du film.
     */
    public String getPays() {
        return pays;
    }

    /**
     * Définit le pays d'origine du film.
     *
     * @param pays Le pays d'origine du film.
     */
    public void setPays(String pays) {
        this.pays = pays;
    }

    /**
     * Obtient le réalisateur du film.
     *
     * @return Le réalisateur du film.
     */
    public Realisateur getRealisateur() {
        return realisateur;
    }

    /**
     * Définit le réalisateur du film.
     *
     * @param realisateur Le réalisateur du film.
     */
    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    /**
     * Obtient la liste des acteurs qui ont joué dans le film.
     *
     * @return La liste des acteurs du film.
     */
    public List<Acteur> getActeurs() {
        return acteurs;
    }
}
