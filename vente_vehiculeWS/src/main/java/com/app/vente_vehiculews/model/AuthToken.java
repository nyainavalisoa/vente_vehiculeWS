package com.app.vente_vehiculews.model;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "authtoken")
public class AuthToken {
    @Id
    @Column(name = "idauth")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_token")
    @SequenceGenerator(name = "pk_token",sequenceName = "s_idauthtoken",allocationSize = 1)
    Integer idauth;
    String token;
    @Column(name = "date_expiration")
    Date date_expiration;

    public Integer getIdauth() {
        return idauth;
    }

    public void setIdauth(Integer idauth) {
        this.idauth = idauth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    //generation de token
    public void generateToken(String email, String mdp){
        Algorithm algorithm = Algorithm.HMAC256("cle_secrete".getBytes());

        try {
            //mila soloina +4semaine ity date par defaut ito
            this.date_expiration  = new SimpleDateFormat("dd/MM/yyyy").parse("12/02/2024");
            this.token = JWT.create().withExpiresAt(date_expiration)
                        .withClaim("email", email).withClaim("mdp", mdp).sign(algorithm);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /*  verifie si la date actuel depasse la date d'expiration
    *   =>true si la date est apres date_expiration
    *   =>false si la date est avant date_exiration
    * */
    public boolean isTokenValid() {
        Date currentDate=new Date();
        return currentDate.before(this.date_expiration);
    }

    @Override
    public String toString() {
        return "AuthToken{" +
                "idauth=" + idauth +
                ", token='" + token + '\'' +
                ", date_expiration=" + date_expiration +
                '}';
    }
}
