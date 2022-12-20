package com.example.avion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.avion.repository.*;
import com.example.avion.retour.ErrorRetour;
import com.example.avion.retour.SuccessRetour;
import com.example.avion.modele.*;
import com.example.avion.exeption.*;
import java.time.*;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UtilisateurController {
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @PostMapping("/login")
    public @ResponseBody Map<String, Object> logins(@RequestBody Utilisateur utilisateur) throws Exception {
        System.out.println("eeee "+utilisateur.getLogins()+"    "+utilisateur.getMotDePasse());
        Utilisateur user = utilisateurRepository.logins(utilisateur.getLogins(), utilisateur.getMotDePasse());
        System.out.println("eeee "+user.getLogins());
        if( user == null ){
            throw new RessourceException(new ErrorRetour("Compte innexistant",HttpStatus.NOT_FOUND.value()));
        }
        else{
            Token t = new Token().generateToken(user,1);
            tokenRepository.save(t);
            Map<String, Object> data = new HashMap<String, Object>();
            Token token = tokenRepository.getTokenByUserNotExpired(user.getIdUtilisateur());
            data.put("data", new SuccessRetour("Vous êtes bien connectée "+user.getNom()));
            data.put("token", token);
            return data;
        }
    }

    @GetMapping("{tokenValues}")
    public @ResponseBody Map<String, Object> deconnexion(@PathVariable String tokenValues){
        Token token = tokenRepository.getToken(tokenValues);
        if( token == null ){
            throw new RessourceException(new ErrorRetour("Token déja expiré",HttpStatus.NOT_FOUND.value()));
        }
        else{
            token.setDateExpiration(LocalDateTime.now());
            tokenRepository.save(token);
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("data", new SuccessRetour("Déconnexion succès"));
            return data;
        }
    }

}