package com.example.avion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.avion.repository.*;
import com.example.avion.retour.ErrorRetour;
import com.example.avion.retour.SuccessRetour;
import com.example.avion.modele.*;
import com.example.avion.exeption.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/avions")
public class AvionController {

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private TokenRepository tokenRepository; 
    
    @Autowired
    private V_AvionRepository v_avionRepository;

    @Autowired
    private KilometrageRepository kilometrageRepository;


    @GetMapping("/listeAvions")
    public @ResponseBody Map<String, Object> getAllAvion(){
        try{
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("data", v_avionRepository.findAll());
            return data;
        }
        catch(Exception e){
            throw new RessourceException(new ErrorRetour("Veuillez vérifier les informations",HttpStatus.BAD_REQUEST.value()));
        }
    }


    public void isTokenExipered(String tokenValues)throws Exception{
        
        System.out.println("Eto "+tokenValues);
        Token token = tokenRepository.getToken(tokenValues);
        
        token.bearerToken(token);
    }
    
    @GetMapping("{idAvion}")
    public @ResponseBody Map<String, Object> getDetailAvion(@PathVariable int idAvion, @RequestParam(name="token") String tokenValues) throws Exception{
        
        System.out.println("Eto "+tokenValues+" "+idAvion);
        isTokenExipered(tokenValues);
        try{
            Map<String, Object> data = new HashMap<String, Object>();
            V_avion avion = v_avionRepository.getAvion(idAvion);
            data.put("avion", avion);
            data.put("kilometrage", kilometrageRepository.findAll());
            return data;
        }
        catch(Exception e){
            throw new RessourceException(new ErrorRetour("Veuillez vérifier les informations",HttpStatus.BAD_REQUEST.value()));
        }
    }

    @PostMapping
    public @ResponseBody Map<String, Object> createAvion(@RequestBody Avion avion) throws Exception{
        try{
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("data", avionRepository.save(avion));
            return data;
        }
        catch(Exception e){
            throw new RessourceException(new ErrorRetour("Veuillez vérifier les informations",HttpStatus.BAD_REQUEST.value()));
        }
    }

    @PutMapping("{idAvion}")
    public @ResponseBody Map<String, Object> updateAvion(@PathVariable int idAvion,@RequestBody Avion avion) {
        Avion updateAvion = avionRepository.findById(idAvion).orElseThrow(() 
            -> new RessourceException(new ErrorRetour("Le idAvion : "+idAvion+" n'existe pas",HttpStatus.NO_CONTENT.value()))
        );
        updateAvion.setIdCompagnie(avion.getIdCompagnie());
        updateAvion.setNomAvion(avion.getNomAvion());
        updateAvion.setPhoto(avion.getPhoto());
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", avionRepository.save(updateAvion));
        return data;
    }

    @DeleteMapping("{idAvion}")
    public @ResponseBody Map<String, Object> deleteAvion(@PathVariable int idAvion)throws Exception{
        Avion avion = avionRepository.findById(idAvion).orElseThrow(() 
            -> new RessourceException(new ErrorRetour("idAvion : "+idAvion+" n'existe pas",HttpStatus.NOT_FOUND.value()))
        );
        avionRepository.delete(avion);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", new SuccessRetour("L'avion dont l'idAvion est "+idAvion+" a été supprimé avec succès"));
        return data;
    }
}