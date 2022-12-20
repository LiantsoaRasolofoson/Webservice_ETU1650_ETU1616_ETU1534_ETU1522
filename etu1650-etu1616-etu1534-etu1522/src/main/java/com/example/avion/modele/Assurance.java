package com.example.avion.modele;

import java.sql.Date;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Assurance")
public class Assurance {
    
    @Id
    @Column(name = "idassurance")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAssurance;

    @Column(name = "dateassurance")
    private Date dateAssurance;

    @Column(name = "dateexpiration")
    private Date dateExpiration;

    @Column( name = "idavion")
    private int idAvion;

}
