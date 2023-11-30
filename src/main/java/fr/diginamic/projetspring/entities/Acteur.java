package fr.diginamic.projetspring.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @OneToMany(mappedBy = "acteur")
    private List<Role> roles;

    // Constructeurs
    public Acteur() {
    }

    public Acteur(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    // Getters et Setters
    // ...

    // Autres méthodes, si nécessaire
}
