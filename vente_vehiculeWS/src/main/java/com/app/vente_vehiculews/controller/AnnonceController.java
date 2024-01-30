package com.app.vente_vehiculews.controller;

import com.app.vente_vehiculews.model.Annonce;
import com.app.vente_vehiculews.model.AnnonceDetails;
import com.app.vente_vehiculews.repository.AnnonceRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/annonces")
public class AnnonceController {
    private final AnnonceRepository annonceRepo;

    public AnnonceController(AnnonceRepository annonceRepo) {
        this.annonceRepo = annonceRepo;
    }

    @GetMapping
    List<Annonce> listAnnonceFront(){
        return annonceRepo.listAnnonceFront();
    }
}
