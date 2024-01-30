package com.app.vente_vehiculews.controller;

import com.app.vente_vehiculews.model.Admin;
import com.app.vente_vehiculews.model.AuthToken;
import com.app.vente_vehiculews.model.Utilisateur;
import com.app.vente_vehiculews.repository.AuthTokenRepository;
import com.app.vente_vehiculews.repository.UtilisateurRepository;
import jakarta.persistence.NoResultException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    UtilisateurRepository utilisateurrepo;
     AuthTokenRepository authtokenrepo;

    public UtilisateurController(AuthTokenRepository authtokenrepo) {
        this.authtokenrepo = authtokenrepo;
    }

    @PostMapping
    public void inscription(@RequestBody Utilisateur u){
         utilisateurrepo.save(u);
    }


    @PostMapping("/checkLogin")
    public Object[] login(@RequestBody Map<String, Object> payload) throws NoResultException {
        Object[] tokenUser = new Object[2];
        String email = (String) payload.get("email");
        String mdp = (String) payload.get("mdp");
        List<Utilisateur> allUser = utilisateurrepo.findAll();

        System.out.println("Email et mdp "+email + mdp);

        for (Utilisateur user : allUser) {
            System.out.println(user.getEmail() + user.getMdp());
            if (user.getEmail().equals(email) && user.getMdp().equals(mdp)) {
                //creation de token
                AuthToken token = new AuthToken();
                token.generateToken(email, mdp);
                //sauvegarde token database
                authtokenrepo.save(token);

                //tableau a retourner vers l'admin
                tokenUser[0] = token.getToken();
                tokenUser[1] = user.getIdutilisateur();
                return tokenUser;
            }
        }
        throw new NoResultException("Non identifier");
    }
}
