package com.example.imcbean;

import java.util.HashMap;
import java.util.Map;

public class ImcBean {


    private String taille;
    private String poids;
    private float value;

    private String message;
    private Map<String, String> errors;

    public String getMessage() {
        return calculRange(value);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ImcBean() {
        taille = "";
        poids = "";
        message = "";
        errors = new HashMap<>();
    }

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

    public boolean validate() {
        errors = new HashMap<>();
        boolean validate = true;
        if (taille.isEmpty()) {
            errors.put("taille", " La taille ne doit pas être vide !");
            validate = false;
        } else {
            if (!floatIsPars("taille", taille))
                validate=false;
            else {
                if (Integer.parseInt(taille) < 80 || Integer.parseInt(taille) > 240) {
                    errors.put("taille", " La taille doit pas être comprise entre 80 et 240 !");
                    validate = false;
                }
            }

        }
        if (poids.isEmpty()) {
            errors.put("poids", " Le poids ne doit pas être vide !");
            validate = false;
        } else {
            if (!floatIsPars("poids", poids))
                validate=false;
            else {
                if (Integer.parseInt(poids) < 30) {
                    errors.put("poids", " Le poids doit être supérieur à 30 !");
                    validate = false;
                }
            }

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

        return calculImc(Float.parseFloat(taille), Float.parseFloat(poids));
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float calculImc(Float taille, Float poids) {
        taille = taille / 100;
        this.value = (poids / (taille * taille));
        return (poids / (taille * taille));
    }


    public String calculRange(float value) {

        if (value >= 40)
            return "Obésité massive";
        if (value > 35)
            return "Obésité sévère";
        if (value > 30)
            return "Obésité modérée";
        if (value > 25)
            return "surpoids";
        if (value > 18.5)
            return "poids normal";
        if (value > 16.5)
            return "maigreur";
        else
            return "dénutrition";
    }

    @Override
    public String toString() {

        return
                value + " " +
                        message
                ;
    }

    public boolean floatIsPars(String messageErreur, String chaine) {

        try {
            Float.parseFloat(chaine);
            return true;
        } catch (Exception e) {
            errors.put(messageErreur, " Le champs doit être numérique");
            return false;
        }
    }

}
