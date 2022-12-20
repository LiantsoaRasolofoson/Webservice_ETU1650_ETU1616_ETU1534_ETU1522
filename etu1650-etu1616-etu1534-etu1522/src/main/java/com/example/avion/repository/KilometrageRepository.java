package com.example.avion.repository;

import com.example.avion.modele.Kilometrage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KilometrageRepository extends JpaRepository<Kilometrage, Integer> {
    // all crud database methods
}

