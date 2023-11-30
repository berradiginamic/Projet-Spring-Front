package fr.diginamic.projetspring.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private int anneeSortie;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    @OneToMany(mappedBy = "film")
    private List<Role> roles;

    @ManyToMany
    @JoinTable(
            name = "film_genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    // Constructeurs
    public Film() {
    }

    public Film(String titre, int anneeSortie, Realisateur realisateur) {
        this.titre = titre;
        this.anneeSortie = anneeSortie;
        this.realisateur = realisateur;
    }

    // Getters et Setters
    // ...

    // Autres méthodes, si nécessaire
}

