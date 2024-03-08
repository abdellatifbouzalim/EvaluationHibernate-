package org.example.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employes")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    // Constructeurs, getters, setters...
}
