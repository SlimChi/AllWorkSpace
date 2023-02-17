package fr.entities;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Data
@Table(name="COULEUR", schema="dbo", catalog="sdbm")

public class CouleurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_COULEUR")
    private Integer id;

    @Column(name = "NOM_COULEUR")
    private String nom;
}
