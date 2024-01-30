package com.app.vente_vehiculews.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Utilisateur{

    @Id
    @Column(name = "idutilisateur")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_utilisateur")
    @SequenceGenerator(name = "pk_utilisateur",sequenceName = "s_idutilisateur",allocationSize = 1)
    private Long idutilisateur;

    private String nom;
    private String adresse;
    private String contact;

    private String email;

    private String mdp;


    public Long getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Long idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idutilisateur='" + idutilisateur + '\'' +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
