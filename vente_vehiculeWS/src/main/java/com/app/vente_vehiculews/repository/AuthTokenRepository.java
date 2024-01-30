package com.app.vente_vehiculews.repository;

import com.app.vente_vehiculews.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AuthTokenRepository extends JpaRepository<AuthToken, Integer>{
    @Query("SELECT idauth  FROM AuthToken where token = ?1")
    Integer findIdByToken(String token);

}
