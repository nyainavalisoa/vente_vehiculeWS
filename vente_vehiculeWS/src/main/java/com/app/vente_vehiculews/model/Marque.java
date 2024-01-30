package com.app.vente_vehiculews.model;

import jakarta.persistence.*;

@Entity
public class Marque {

    @Id
    @Column(name = "idmarque")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_marque")
    @SequenceGenerator(name = "pk_marque",sequenceName = "s_idmarque",allocationSize = 1)
    Integer id;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "marque{" +
                "idmarque=" + id +
                ", nom=" + nom + '\'' +
                '}';
    }
}
