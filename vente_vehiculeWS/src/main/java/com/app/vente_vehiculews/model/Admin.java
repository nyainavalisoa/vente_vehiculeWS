package com.app.vente_vehiculews.model;

import jakarta.persistence.*;

@Entity
public class Admin{
    @Id
    @Column(name = "idadmin")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_admin")
    @SequenceGenerator(name = "pk_admin",sequenceName = "s_idadmin",allocationSize = 1)
    Integer id;

    private String email;
    private String mdp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return mdp;
    }

    public void setPassword(String password) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Admin{" +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }

}
