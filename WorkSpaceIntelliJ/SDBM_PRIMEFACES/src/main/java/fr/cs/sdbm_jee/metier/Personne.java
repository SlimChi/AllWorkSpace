package fr.cs.sdbm_jee.metier;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.Size;

@Named
@RequestScoped
public class Personne {
    @Size(min = 2, max = 15)
    private String nom;
    @Size(min = 2, max = 15)
    private String prenom;
    private NIR nir;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public NIR getNir() {
        return nir;
    }

    public void setNir(NIR nir) {
        this.nir = nir;
    }
}
