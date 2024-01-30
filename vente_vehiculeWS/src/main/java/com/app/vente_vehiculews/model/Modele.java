package com.app.vente_vehiculews.model;

import jakarta.persistence.*;

@Entity
public class Modele {
    @Id
    @Column(name = "idmodele")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_modele")
    @SequenceGenerator(name = "pk_modele",sequenceName = "s_idmodele",allocationSize = 1)
    Long idmodele;
    String reference_nom;

    public String getReference_nom() {
        return reference_nom;
    }

    public void setReference_nom(String reference_nom) {
        this.reference_nom = reference_nom;
    }

    public Long getIdmodele() {
        return idmodele;
    }

    public void setIdmodele(Long idmodele) {
        this.idmodele = idmodele;
    }

    @Override
    public String toString() {
        return "Modele{" +
                "idmodele=" + idmodele +
                ", refernce_nom=" + reference_nom + '\'' +
                '}';
    }
}
