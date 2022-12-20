package com.example.avion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.avion.modele.Assurance;


public interface AssuranceRepository extends JpaRepository<Assurance, Integer>{

}
