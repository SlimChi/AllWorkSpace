package fr.cs.javajstl.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class CompetencesBean implements Serializable {
    private String nom;
    private ArrayList<String> competences;
    private ArrayList<String> competencesMaitrisees;
    private ArrayList<String> competencesManquantes;

    public CompetencesBean() {
        competences = new ArrayList<>();
        competencesMaitrisees = new ArrayList<>();
        competencesManquantes = new ArrayList<>();

        competences.addAll(Arrays.asList("Java", "Git", "Docker", "Php", "JavaScript", "React", "Ruby", "Sql", "Html", "Css", "C++"));
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<String> getCompetences() {
        return competences;
    }

    public void setCompetences(ArrayList<String> competences) {
        this.competences = competences;
    }

    public ArrayList<String> getCompetencesMaitrisees() {
        return competencesMaitrisees;
    }

    public void setCompetencesMaitrisees(String[] competencesMaitrisees) {
        if (competencesMaitrisees != null)
            this.competencesMaitrisees.addAll(Arrays.asList(competencesMaitrisees));
        for (String competence : competences) {
            if (!this.competencesMaitrisees.contains(competence))
                competencesManquantes.add(competence);
        }
    }

    public ArrayList<String> getCompetencesManquantes() {
        return competencesManquantes;
    }

    public void setCompetencesManquantes(ArrayList<String> competencesManquantes) {
        this.competencesManquantes = competencesManquantes;
    }

    @Override
    public String toString() {
        return nom
                ;
    }
}
