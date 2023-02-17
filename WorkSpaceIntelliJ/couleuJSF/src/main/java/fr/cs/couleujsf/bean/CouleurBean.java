package fr.cs.couleujsf.bean;

import fr.cs.couleujsf.metier.Couleur;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CouleurBean implements Serializable {


    private static ArrayList<Couleur> allCouleur;
    private Couleur couleurSelected;

    @PostConstruct
    private void init(){
        Couleur rouge = new Couleur(1,"rouge");
        Couleur bleu = new Couleur(2,"bleu");
        Couleur blanc = new Couleur(3,"blanc");
        Couleur jaune = new Couleur(4,"jaune");
        Couleur noir = new Couleur(5,"noir");

        allCouleur = new ArrayList<>();

        allCouleur.add(rouge);
        allCouleur.add(bleu);
        allCouleur.add(blanc);
        allCouleur.add(jaune);
        allCouleur.add(noir);

    }
    public ArrayList<Couleur> getAllCouleur(){
        return allCouleur;
    }
    public Couleur getCouleurSelected(){
        return couleurSelected;
    }
    public void setCouleurSelected(Couleur couleurSelected){
        this.couleurSelected = couleurSelected;
    }

//    public void couleurChange(ValueChangeEvent e){
//        Couleur nouvelleCouleur = (Couleur) e.getNewValue();
//        nouvelleCouleur = couleurSelected;
//    }
//    public String envoyer() {
//        return "envoyerOK";
//    }
}
