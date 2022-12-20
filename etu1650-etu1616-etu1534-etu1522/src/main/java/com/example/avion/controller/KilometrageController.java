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
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/kilometrages")
public class KilometrageController {

    @Autowired
    private KilometrageRepository kilometrageRepository;

    @GetMapping
    public @ResponseBody Map<String, Object> getAllKilometrage(){
        try{
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("data", kilometrageRepository.findAll());
            return data;
        }
        catch(Exception e){
            throw new RessourceException(new ErrorRetour("Veuillez vérifier les informations",HttpStatus.BAD_REQUEST.value()));
        }
    }

    @PostMapping
    public  @ResponseBody Map<String, Object> createKilometrage(@RequestBody Kilometrage kilometrage) {
        try{
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("data", kilometrageRepository.save(kilometrage));
            return data;
        }
        catch(Exception e){
            throw new RessourceException(new ErrorRetour("Veuillez vérifier les informations",HttpStatus.BAD_REQUEST.value()));
        }
    }

    @PutMapping("{idKilometrage}")
    public @ResponseBody Map<String, Object> updateKilometrage(@PathVariable int idKilometrage,@RequestBody Kilometrage kilometrageDetails) {
        Kilometrage updateKilometrage = kilometrageRepository.findById(idKilometrage).orElseThrow(() 
            -> new RessourceException(new ErrorRetour("Le idKilometrage : "+idKilometrage+" n'existe pas",HttpStatus.NO_CONTENT.value()))
        );
        updateKilometrage.setDebutKm(kilometrageDetails.getDebutKm());
        updateKilometrage.setFinKm(kilometrageDetails.getFinKm());
        updateKilometrage.setIdAvion(kilometrageDetails.getIdAvion());
        updateKilometrage.setDateKm(kilometrageDetails.getDateKm());
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", kilometrageRepository.save(updateKilometrage));
        return data;
    }

    @DeleteMapping("{idKilometrage}")
    public @ResponseBody Map<String, Object> deletMarque(@PathVariable int idKilometrage){
        Kilometrage kilometrage = kilometrageRepository.findById(idKilometrage).orElseThrow(() 
            -> new RessourceException(new ErrorRetour("Le idKilometrage : "+idKilometrage+" n'existe pas",HttpStatus.NO_CONTENT.value()))
        );
        kilometrageRepository.delete(kilometrage);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", new SuccessRetour("Le kilometrage dont l'idKilometrage est "+idKilometrage+" a été supprimé avec succès"));
        return data;

    }
}