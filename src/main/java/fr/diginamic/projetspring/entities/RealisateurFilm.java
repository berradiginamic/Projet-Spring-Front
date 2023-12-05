package fr.diginamic.projetspring.entities;
<<<<<<< HEAD
=======

>>>>>>> origin/master
import jakarta.persistence.*;

@Entity
@Table(name = "realisateur_film")
public class RealisateurFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Integer idRealisateurFilm;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
=======
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_realisateur")
>>>>>>> origin/master
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

<<<<<<< HEAD
    public Integer getIdRealisateurFilm() {
        return idRealisateurFilm;
    }

    public void setIdRealisateurFilm(Integer idRealisateurFilm) {
        this.idRealisateurFilm = idRealisateurFilm;
=======
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
>>>>>>> origin/master
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
<<<<<<< HEAD
                "id=" + idRealisateurFilm +
=======
                "id=" + id +
>>>>>>> origin/master
                ", realisateur=" + realisateur +
                ", film=" + film +
                '}';
    }
}
