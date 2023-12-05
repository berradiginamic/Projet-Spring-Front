package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "film_genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    private String nom;
    private String idIMDB;
    private Integer anneeSortie;
    private String rating;
    private String urlProfile;
    private String lieuTournage;
    private String langue;
    private String resume;
    private String pays;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RealisateurFilm> realisateurFilms;

    public Film() {
    }

    public Film(Integer anneeSortie, String langue, String lieuTournage, String nom, String pays, String rating, String resume, String urlProfile, List<Genre> genres) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<RealisateurFilm> getRealisateurFilms() {
        return realisateurFilms;
    }

    public void setRealisateurFilms(List<RealisateurFilm> realisateurFilms) {
        this.realisateurFilms = realisateurFilms;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + idIMDB + '\'' +
                ", anneeSortie=" + anneeSortie +
                ", langue='" + langue + '\'' +
                ", lieuTournage='" + lieuTournage + '\'' +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                ", rating=" + rating +
                ", resume='" + resume + '\'' +
                ", urlProfile='" + urlProfile + '\'' +
                ", genres='" + genres + '\'' +
                ", realisateur=" + realisateur +
                '}';
    }
}
