package com.app.vente_vehiculews.repository;

import com.app.vente_vehiculews.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
