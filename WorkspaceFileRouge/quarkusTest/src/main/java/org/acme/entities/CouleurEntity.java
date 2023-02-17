package org.acme.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CouleurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_COULEUR")
    private Integer id;

    @Column(name = "NOM_COULEUR")
    private String nom;
}
