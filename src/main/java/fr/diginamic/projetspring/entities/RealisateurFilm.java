package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "realisateur_film")
public class RealisateurFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRealisateurFilm;

    @ManyToOne
    @JoinColumn(name = "realisateur_id", referencedColumnName = "idRealisateur")
    private Realisateur realisateur;

    @Column(name = "realisateur_id", insertable = false, updatable = false)
    private Integer idRealisateur;

    /** Film dans lequel le rôle est joué. */
    @ManyToOne()
    @JoinColumn(name = "film_id", referencedColumnName = "filmId")
    private Film film;

    @Column(name = "film_id", insertable = false, updatable = false)
    private Integer filmId;

    public RealisateurFilm() {
    }

    public RealisateurFilm(Integer idRealisateurFilm, Realisateur realisateur, Film film) {
        this.idRealisateurFilm = idRealisateurFilm;
        this.idRealisateur = (realisateur != null) ? realisateur.getIdRealisateur() : null;
        this.filmId = (film != null) ? film.getFilmId() : null;
    }

    // Getters et Setters


    public Integer getIdRealisateurFilm() {
        return idRealisateurFilm;
    }

    public void setIdRealisateurFilm(Integer idRealisateurFilm) {
        this.idRealisateurFilm = idRealisateurFilm;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public Integer getIdRealisateur() {
        return idRealisateur;
    }

    public void setIdRealisateur(Integer idRealisateur) {
        this.idRealisateur = idRealisateur;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "RealisateurFilm{" + "idRealisateurFilm= " + idRealisateurFilm;
    }
}
