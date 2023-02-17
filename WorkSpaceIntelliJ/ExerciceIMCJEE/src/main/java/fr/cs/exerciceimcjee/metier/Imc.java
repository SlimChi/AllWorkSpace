package fr.cs.exerciceimcjee.metier;


public class Imc {
    private float taille;
    private float poids;
    private float imc;

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

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    @Override
    public String toString() {
        return ("Votre Imc est : " + this.imc);
    }

    public Imc(String taille, String poids) {
        try {
            this.taille = Float.parseFloat(taille);
            this.poids = Float.parseFloat(poids);
            this.imc = calculImc(this.poids, this.taille);
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static float calculImc(Float poids, Float taille) {
        return ((poids / (taille * taille))) * 10000;

    }

    public String calculRange() {

        if (imc >= 40)
            return "Obésité massive";
        if (imc > 35)
            return "Obésité sévère";
        if (imc > 30)
            return "Obésité modérée";
        if (imc > 25)
            return "surpoids";
        if (imc > 18.5)
            return "poids normal";
        if (imc > 16.5)
            return "maigreur";
        else
            return "dénutrition";
    }
}
