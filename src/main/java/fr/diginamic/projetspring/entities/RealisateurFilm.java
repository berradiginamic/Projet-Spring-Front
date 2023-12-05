package fr.diginamic.projetspring.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "realisateur_film")
public class RealisateurFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRealisateurFilm;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "RealisateurFilm{" +
                "id=" + idRealisateurFilm +
                ", realisateur=" + realisateur +
                ", film=" + film +
                '}';
    }
}
