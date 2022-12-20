package com.example.avion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.avion.modele.V_assurance;

public interface V_assuranceRepository extends JpaRepository<V_assurance, Integer>{
    @Query(value="SELECT * FROM v_assurance WHERE idavion=?1 ORDER BY dateexpiration desc limit 1", nativeQuery=true)
    public V_assurance  getLastAssurance(int idAvion);
}
