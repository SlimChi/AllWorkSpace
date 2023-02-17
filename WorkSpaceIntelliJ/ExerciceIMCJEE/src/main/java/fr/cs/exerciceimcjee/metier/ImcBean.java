package fr.cs.exerciceimcjee.metier;

import java.util.HashMap;
import java.util.Map;

public class ImcBean {
    private String taille;
    private String poids;
    private float value;
    private Map<String, String> errors;

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public boolean validate(){
        errors = new HashMap<>();
        boolean validate = true;
        if (taille.isEmpty()){
            errors.put("taille", "le nom ne doit pas être vide !");
            validate = false;
        }
        if (poids.isEmpty()){
            errors.put("poids", "le prenom ne doit pas être vide !");
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public static float calculImc(Float poids, Float taille) {
        return ((poids / (taille * taille))) * 10000;

    }
}
