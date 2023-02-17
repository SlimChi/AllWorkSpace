package fr.cs.jsf01.metier;

public class Personne {
    private String nom;
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
