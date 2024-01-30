package com.app.vente_vehiculews.model;

import jakarta.persistence.*;

@MappedSuperclass

//list vers frontoffice
@NamedNativeQuery(
        name="listAnnonceFront",
        query = "select *" +
                " from annonce where validation_annonce=true",
        resultClass = AnnonceDetails.class
)
public class Annonce {
    @Id
    @Column(name = "idannonce")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_annonce")
    @SequenceGenerator(name = "pk_annonce",sequenceName = "s_idannonce",allocationSize = 1)
    Integer idannonce;

    int idutilisateur;
    String titre;
    String descriptions;

    @Column(name = "idcategorie")
    int idcategorie;
    @Column(name = "idmarque")
    int idmarque;
    @Column(name = "idmodele")
    int idmodele;
    double prix;
    String photo;
    boolean statusvente;
    boolean validation_annonce;
    double commission;

    public Integer getIdannonce() {
        return idannonce;
    }

    public void setIdannonce(Integer idannonce) {
        this.idannonce = idannonce;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public int getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }

    public int getIdmodele() {
        return idmodele;
    }

    public void setIdmodele(int idmodele) {
        this.idmodele = idmodele;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isStatusvente() {
        return statusvente;
    }

    public void setStatusvente(boolean statusvente) {
        this.statusvente = statusvente;
    }

    public boolean isValidation_annonce() {
        return validation_annonce;
    }

    public void setValidation_annonce(boolean validation_annonce) {
        this.validation_annonce = validation_annonce;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "idannonce=" + idannonce +
                ",idutilisateur=" + idutilisateur +
                ", descriptions='" + descriptions +
                ", idcategorie=" + idcategorie +
                ", idmarque=" + idmarque +
                ", idmodele=" +  idmodele+
                ", prix=" + prix +
                ", photo=" + photo +
                ", statusvente=" + statusvente +
                ", validation_annonce=" + validation_annonce +
                ", commission=" + commission +
                '}';
    }

    public Annonce() {
    }
}
