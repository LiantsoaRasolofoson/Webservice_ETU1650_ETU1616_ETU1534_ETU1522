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
@Table(name = "utilisateur")

public class Utilisateur {
    
    @Id
    @Column(name = "idutilisateur")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "logins")
    private String logins;

    @Column(name = "motdepasse")
    private String motDePasse;

}
