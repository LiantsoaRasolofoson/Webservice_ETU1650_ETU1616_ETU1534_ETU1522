package com.example.avion.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kilometrage")

public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkilometrage")
    private int idKilometrage;

    @Column(name = "debutkm")
    private int debutKm;

    @Column(name = "finkm")
    private int finKm;

    @Column(name = "datekm")
    private Date dateKm;

    @Column(name = "idavion")
    private int idAvion;

}