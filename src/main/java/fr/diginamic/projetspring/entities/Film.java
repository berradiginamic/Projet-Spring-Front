package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer filmId;

    private String nom;
    private String idIMDB;
    private Integer anneeSortie;
    private String rating;
    private String urlProfile;
    private String lieuTournage;
    private String langue;
    private String genres;
    private String resume;
    private String pays;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RealisateurFilm> realisateurFilms;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Film() {
    }

    public Film(Integer anneeSortie, String langue, String lieuTournage, String nom, String pays, String rating, String resume, String urlProfile, String genres) {
        this.anneeSortie = anneeSortie;
        this.langue = langue;
        this.lieuTournage = lieuTournage;
        this.nom = nom;
        this.pays = pays;
        this.rating = rating;
        this.resume = resume;
        this.urlProfile = urlProfile;
        this.genres = genres;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
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

    public Integer getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(Integer anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
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

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
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

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", titre='" + idIMDB + '\'' +
                ", anneeSortie=" + anneeSortie +
                ", langue='" + langue + '\'' +
                ", lieuTournage='" + lieuTournage + '\'' +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                ", rating=" + rating +
                ", resume='" + resume + '\'' +
                ", urlProfile='" + urlProfile + '\'' +
                ", genre='" + genres + '\'' +
                ", realisateur=" + realisateur +
                '}';
    }
}
