package fr.cs.sdbmhibernateapi.entities;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "couleur.getAll",
        query = "SELECT c FROM CouleurEntity c ORDER BY c.idCouleur")
@Table(name = "COULEUR", schema = "dbo", catalog = "SDBM")
public class CouleurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COULEUR")
    private int idCouleur;
    @Basic
    @Column(name = "NOM_COULEUR")
    private String nomCouleur;

    public int getIdCouleur() {
        return idCouleur;
    }

    public void setIdCouleur(int idCouleur) {
        this.idCouleur = idCouleur;
    }

    public String getNomCouleur() {
        return nomCouleur;
    }

    public void setNomCouleur(String nomCouleur) {
        this.nomCouleur = nomCouleur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CouleurEntity that = (CouleurEntity) o;

        if (idCouleur != that.idCouleur) return false;
        if (nomCouleur != null ? !nomCouleur.equals(that.nomCouleur) : that.nomCouleur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCouleur;
        result = 31 * result + (nomCouleur != null ? nomCouleur.hashCode() : 0);
        return result;
    }
}
