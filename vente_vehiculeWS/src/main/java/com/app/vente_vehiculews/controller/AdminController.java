package com.app.vente_vehiculews.controller;

import com.app.vente_vehiculews.model.*;
import com.app.vente_vehiculews.repository.*;
import jakarta.persistence.NoResultException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminRepository adminrepo;
    private final AuthTokenRepository authtokenrepo;
    private final CategorieRepository categorepo;
    private final  MarqueRepository marquerepo;
    private final ModeleRepository modelerepo;

    public AdminController(AdminRepository adminrepo, AuthTokenRepository authtokenrepo, CategorieRepository categorepo, MarqueRepository marquerepo, ModeleRepository modelerepo) {
        this.adminrepo = adminrepo;
        this.authtokenrepo = authtokenrepo;
        this.categorepo = categorepo;
        this.marquerepo = marquerepo;
        this.modelerepo = modelerepo;
    }

    @PostMapping("/checkLogin")
    public Object[] login(@RequestBody Map<String, Object> payload) throws NoResultException{
                Object[] tokenAdmin = new Object[2];
                String email = (String) payload.get("email");
                String mdp = (String) payload.get("mdp");
                List<Admin> allAdmin = adminrepo.findAll();

                System.out.println("Email et mdp "+email + mdp);

                for (Admin admin : allAdmin) {
                    System.out.println(admin.getEmail() + admin.getPassword());
                    if (admin.getEmail().equals(email) && admin.getPassword().equals(mdp)) {
                        //creation de token
                        AuthToken token = new AuthToken();
                        token.generateToken(email, mdp);
                        Integer idauth=authtokenrepo.findIdByToken(token.getToken());
                        if(idauth!=0){
                            //tableau a retourner vers l'admin
                            tokenAdmin[0] = token.getToken();
                            tokenAdmin[1] = admin.getId();
                        }
                        else {
                            tokenAdmin[0] = token.getToken();
                            tokenAdmin[1] = admin.getId();
                            //sauvegarde token database
                            authtokenrepo.save(token);
                        }

                        return tokenAdmin;
                    }
                }
                throw new NoResultException("Non identifier");
            }


    @PostMapping("/categorie")
    public void saveCategorie(@RequestBody Categorie c){
        categorepo.save(c);
    }

    @PostMapping("/modele")
    public void saveModele(@RequestBody Modele m){
        modelerepo.save(m);
    }

    @PostMapping("/marque")
    public void saveMarque(@RequestBody Marque marque){
        marquerepo.save(marque);
    }


}
