package com.example.avion.repository;

import com.example.avion.modele.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    
    @Query("SELECT user FROM Utilisateur user WHERE user.logins = ?1 AND user.motDePasse = ?2")
    public Utilisateur logins(String logins, String motDePasse);

}
