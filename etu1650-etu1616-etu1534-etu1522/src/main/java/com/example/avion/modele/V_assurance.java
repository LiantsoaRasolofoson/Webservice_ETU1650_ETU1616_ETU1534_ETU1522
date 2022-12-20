package com.example.avion.modele;

import java.sql.Date;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "v_assurance")
public class V_assurance {

    @Id
    @Column(name = "idavion")
    private int idAvion;

    @Column(name = "nomavion")
    private String nomAvion;

    @Column(name = "idcompagnie")
    private int idCompagnie;

    @Column(name = "photo")
    private String photo;

    @Column(name = "idassurance")
    private int idAssurance;

    @Column(name = "dateassurance")
    private Date dateAssurance;

    @Column(name = "dateexpiration")
    private Date dateExpiration;

}
