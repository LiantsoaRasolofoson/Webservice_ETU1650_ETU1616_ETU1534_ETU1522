package com.example.avion.repository;

import com.example.avion.modele.V_avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface V_AvionRepository extends JpaRepository<V_avion, Integer> {

    @Query(value="SELECT * FROM v_avion v WHERE v.idavion = ?1", nativeQuery =true)
    public V_avion getAvion(int idAvion);
}
