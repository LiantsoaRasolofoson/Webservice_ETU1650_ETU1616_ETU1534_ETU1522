package com.example.avion.repository;

import com.example.avion.modele.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, Integer> {

}
