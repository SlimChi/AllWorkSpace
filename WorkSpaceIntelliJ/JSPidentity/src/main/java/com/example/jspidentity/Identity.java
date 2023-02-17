package com.example.jspidentity;

public class Identity {
    String nom;
    String prenom;

    public String getNom() {
        return nom;
    }

    public Identity() {
    }

    public Identity(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    public Identity identityFromString(String txt){
        String prenom = txt.split(":")[0];
        String nom = txt.split(":")[1];

        return new Identity(prenom,nom);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return
               nom +":" + prenom
                ;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
