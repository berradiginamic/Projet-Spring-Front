package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * Représente un genre de film avec son type et la liste des films associés à ce genre.
 */
@Entity
@Table(name="genres")
public class Genre {

    /**
     * Identifiant unique du genre.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    @ManyToMany(mappedBy = "genres")
    private List<Film> films;

    public Genre() {
    }

    public Genre(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}