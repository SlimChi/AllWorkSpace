package com.example.exo2jsp;

import java.util.HashMap;
import java.util.Map;

public class VisitorBean {
    private String nom = "";
    private String prenom = "";
    private Map<String,String> errors;

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

    public boolean validate(){
        errors = new HashMap<>();
        boolean validate = true;
        if (nom.isEmpty()){
            errors.put("nom", "le nom ne doit pas être vide !");
        validate = false;
        }
        if (prenom.isEmpty()){
            errors.put("prenom", "le prenom ne doit pas être vide !");
            validate = false;
        }
        return validate;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
}
