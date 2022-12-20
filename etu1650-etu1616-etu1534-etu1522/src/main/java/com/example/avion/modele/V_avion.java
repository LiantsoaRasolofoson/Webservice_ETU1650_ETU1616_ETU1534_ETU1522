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
@Table(name = "v_avion")

public class V_avion {
    

    @Column(name = "idcompagnie")
    private int idCompagnie;

    @Column(name = "nomcompagnie")
    private String nomCompagnie;

    @Column(name = "email")
    private String email;

    @Id
    @Column(name = "idavion")
    private int idAvion;

    @Column(name = "nomavion")
    private String nomAvion;

    @Column(name = "photo")
    private String photo;
}
