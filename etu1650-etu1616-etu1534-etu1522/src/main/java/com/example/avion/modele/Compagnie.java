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
@Table(name = "compagnie")

public class Compagnie {


    @Id
    @Column(name = "idcompagnie")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompagnie;

    @Column(name = "nomcompagnie")
    private String nomCompagnie;

    @Column(name = "email")
    private String email;
    
}

