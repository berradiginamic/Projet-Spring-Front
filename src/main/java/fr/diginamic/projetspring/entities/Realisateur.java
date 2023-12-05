package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "realisateurs")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_realisateur")
    private Integer idRealisateur;

    @Column(name = "id_IMDB")
    private String idIMDB;

    private String nom;
    private Date dateNaissance;
    private String lieuNaissance;
    private String urlProfile;

    @OneToMany(mappedBy = "realisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Film> film;

    public Realisateur() {
    }

    public Realisateur(String lieuNaissance, Date dateNaissance, String nom, String urlProfile, String idIMDB) {
        this.lieuNaissance = lieuNaissance;
        this.dateNaissance = dateNaissance;
        this.nom = nom;
        this.urlProfile = urlProfile;
        this.idIMDB = idIMDB;
    }

    public Integer getIdRealisateur() {
        return idRealisateur;
    }

    public void setIdRealisateur(Integer idRealisateur) {
        this.idRealisateur = idRealisateur;
    }

    public String getIdIMDB() {
        return idIMDB;
    }

    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getUrlProfile() {
        return urlProfile;
    }

    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public List<Film> getFilm() {
        return film;
    }

    public void setFilm(List<Film> film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Realisateur{" +
                "idRealisateur=" + idRealisateur +
                ", idIMDB='" + idIMDB + '\'' +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", lieuNaissance='" + lieuNaissance + '\'' +
                ", urlProfile='" + urlProfile + '\'' +
                ", film=" + film +
                '}';
    }
}
