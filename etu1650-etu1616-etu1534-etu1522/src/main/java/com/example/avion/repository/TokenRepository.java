package com.example.avion.repository;

import com.example.avion.modele.Token;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value="SELECT * FROM Token t WHERE t.dateExpiration > now() AND t.idutilisateur = ?1 ORDER BY t.dateExpiration DESC LIMIT 1", nativeQuery =true)
    public Token getTokenByUserNotExpired(int idUtilisateur);

    @Query(value="SELECT * FROM Token t WHERE t.tokenValues = ?1", nativeQuery =true)
    public Token getToken(String tokenValues); 

}
