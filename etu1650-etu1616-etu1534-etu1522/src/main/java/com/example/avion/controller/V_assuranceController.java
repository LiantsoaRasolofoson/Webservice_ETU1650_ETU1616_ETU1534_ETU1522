package com.example.avion.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.avion.exeption.RessourceException;
import com.example.avion.modele.Avion;
import com.example.avion.modele.V_assurance;
import com.example.avion.repository.AssuranceRepository;
import com.example.avion.repository.AvionRepository;
import com.example.avion.repository.V_assuranceRepository;
import com.example.avion.retour.ErrorRetour;


@CrossOrigin("*")
@RestController
@RequestMapping("/assurance")
public class V_assuranceController {

    @Autowired
    private V_assuranceRepository assuranceRepository;

    @Autowired
    private AvionRepository avionrepository;
    

    @GetMapping(value="/expire3")
    public @ResponseBody Map<String, Object> getAssuranceExpire3() {

        try {
            Map<String, Object> data = new HashMap<String, Object>();
            System.out.println("aaa");
            List<V_assurance> expire3 = new ArrayList<V_assurance>();

            List<Avion> avions = avionrepository.findAll();
            
            for(Avion av : avions) {
                V_assurance a = assuranceRepository.getLastAssurance(av.getIdAvion());
                LocalDate now = LocalDate.now();
                LocalDate dateexpire = a.getDateExpiration().toLocalDate();
                if(dateexpire.isAfter(now)) {
                    int month = Period.between(now, dateexpire).getMonths();
                    if(month <= 3) {
                        expire3.add(a);
                    }
                }

            }

            data.put("data", expire3);

            return data;
            
        } catch (Exception e) {
            throw new RessourceException(new ErrorRetour("Veuillez vérifier les informations",HttpStatus.BAD_REQUEST.value()));
        }
        
    }

    @GetMapping(value="/expire1")
    public @ResponseBody Map<String, Object> getAssuranceExpire1() {

        try {
            Map<String, Object> data = new HashMap<String, Object>();
            List<V_assurance> expire1 = new ArrayList<V_assurance>();

            List<Avion> avions = avionrepository.findAll();
            
            for(Avion av : avions) {
                V_assurance a = assuranceRepository.getLastAssurance(av.getIdAvion());
                LocalDate now = LocalDate.now();
                LocalDate dateexpire = a.getDateExpiration().toLocalDate();
                if(dateexpire.isAfter(now)) {
                    int month = Period.between(now, dateexpire).getMonths();
                    if(month <= 1) {
                        expire1.add(a);
                    }
                }

            }

            data.put("data", expire1);

            return data;
            
        } catch (Exception e) {
            throw new RessourceException(new ErrorRetour("Veuillez vérifier les informations",HttpStatus.BAD_REQUEST.value()));
        }
        
    }
    
}
