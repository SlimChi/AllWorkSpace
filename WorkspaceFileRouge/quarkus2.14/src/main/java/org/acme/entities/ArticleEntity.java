package org.acme.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="ARTICLE", schema="dbo", catalog="sdbm")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ARTICLE")
    private Integer id;

    @Column (name="NOM_ARTICLE")
    private String nom;
}
