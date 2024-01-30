package com.app.vente_vehiculews.repository;

import com.app.vente_vehiculews.model.Annonce;
import com.app.vente_vehiculews.model.AnnonceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
    @Query(name="listAnnonceFront", nativeQuery = true)
    public List<Annonce> listAnnonceFront();

}
