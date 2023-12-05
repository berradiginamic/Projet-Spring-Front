package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "realisateur_film")
public class RealisateurFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_realisateur")
    private Realisateur realisateur;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    public RealisateurFilm() {
    }

    public RealisateurFilm(Realisateur realisateur, Film film) {
        this.realisateur = realisateur;
        this.film = film;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "RealisateurFilm{" +
                "id=" + id +
                ", realisateur=" + realisateur +
                ", film=" + film +
                '}';
    }
}
