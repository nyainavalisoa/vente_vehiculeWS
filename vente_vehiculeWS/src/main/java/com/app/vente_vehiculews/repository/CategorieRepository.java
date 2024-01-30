package com.app.vente_vehiculews.repository;

import com.app.vente_vehiculews.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    
}
