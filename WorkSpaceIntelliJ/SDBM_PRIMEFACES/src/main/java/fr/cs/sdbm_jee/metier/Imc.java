package fr.cs.sdbm_jee.metier;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Imc {
    private float taille;
    private float poids;

    public Imc() {



    }

    public Imc(float taille, float poids) {
        this.taille = taille;
        this.poids = poids;
    }

    public String getImcValue() {
        taille = taille / 100;
        float value = poids / (taille * taille);
        return String.format("%.2f", value);

    }


    public String getMessage() {
        float value = poids / (taille * taille);

        System.out.println(value);

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

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }


}
