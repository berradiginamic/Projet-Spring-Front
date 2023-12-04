package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * Représente un genre de film avec son type et la liste des films associés à ce genre.
 */
@Entity
public class Genre {

    /** Identifiant unique du genre. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Type du genre (ex: Action, Comédie, Drame, etc.). */
    private String type;

    /** Liste des films associés à ce genre. */
    @ManyToMany
    @JoinTable(
            name = "film_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> films;

    // Constructeurs
    /**
     * Constructeur par défaut.
     */
    public Genre() {
    }

    /**
     * Constructeur avec type de genre.
     *
     * @param type Le type de genre (ex: Action, Comédie, Drame, etc.).
     */
    public Genre(String type) {
        this.type = type;
    }

    // Getters et Setters

    /**
     * Obtient l'identifiant unique du genre.
     *
     * @return L'identifiant unique du genre.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique du genre.
     *
     * @param id L'identifiant unique du genre.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient le type de genre.
     *
     * @return Le type de genre.
     */
    public String getType() {
        return type;
    }

    /**
     * Définit le type de genre.
     *
     * @param type Le type de genre.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Obtient la liste des films associés à ce genre.
     *
     * @return La liste des films associés à ce genre.
     */
    public List<Film> getFilms() {
        return films;
    }

    /**
     * Définit la liste des films associés à ce genre.
     *
     * @param films La liste des films associés à ce genre.
     */
    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
