package fr.cs.couleujsf.metier;

public class Couleur {
    private int id;
    private String nom;

    public Couleur(int id, String nom ){
        this.id = id;
        this.nom = nom;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return             nom
                ;
    }
}
