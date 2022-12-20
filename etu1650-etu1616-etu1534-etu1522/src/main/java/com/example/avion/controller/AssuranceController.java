package com.example.avion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.avion.repository.AssuranceRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/assurance")
public class AssuranceController {
    
    @Autowired
    private AssuranceRepository assuranceRepository;

}
