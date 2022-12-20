package com.example.avion.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "avion")

public class Avion {


    @Id
    @Column(name = "idavion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAvion;

    @Column(name = "nomavion")
    private String nomAvion;

    @Column(name = "idcompagnie")
    private int idCompagnie;

    @Column(name = "photo")
    private String photo;
    
}

