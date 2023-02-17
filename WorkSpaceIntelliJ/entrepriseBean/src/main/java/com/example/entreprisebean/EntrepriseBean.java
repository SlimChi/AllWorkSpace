package com.example.entreprisebean;

import java.util.HashMap;
import java.util.Map;

public class EntrepriseBean {
    public static final String SIREN_KEY = "siren";
    public static final String CODEPOSTAL_KEY = "codePostal";
    public static final String ADRESSE_KEY = "adresse";
    public static final String RSOCIALE_KEY = "rSociale";
    private String siren;
    private String rSociale;
    private String adresse;
    private String codePostal;
    private String ville;
    private Map<String, String> errors;
    private int cpt;

    public EntrepriseBean() {
        cpt = 0;
        siren = "";
        rSociale = "";
        adresse = "";
        codePostal = "";
        ville = "";
        errors = new HashMap<>();
    }

    public boolean validate() {
        errors = new HashMap<>();
        boolean validate = true;

        if (!ControlAll.verifSiren(siren)) {
             if (cpt > 0)errors.put(SIREN_KEY, "SIREN Incorrect");
            validate = false;
        }

        if (!ControlAll.verifierRsocial(rSociale) ) {
            if (cpt > 0) errors.put(RSOCIALE_KEY, " Raison social invalide !");
            validate = false;
        }
        if (!ControlAll.verifierRegexAdresse(adresse)) {
            if (cpt > 0) errors.put(ADRESSE_KEY, " Adresse invalide !");
            validate = false;
        }
        if (!ControlAll.verifierCodePostal(codePostal)) {
            if (cpt > 0) errors.put(CODEPOSTAL_KEY, " Code Postal Incorrect !");
            validate = false;
        }
        if (ville.isEmpty()) {
            if (cpt > 0) errors.put("ville", " Le champ ne doit pas être vide !");
            validate = false;
        }
        cpt++;
        return validate;
    }

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }

    public String getrSociale() {
        return rSociale;
    }

    public void setrSociale(String rSociale) {
        this.rSociale = rSociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "EntrepriseBean{" +
                "siren='" + siren + '\'' +
                ", rSociale='" + rSociale + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", errors=" + errors +
                '}';
    }

    public int getCpt() {
        return cpt;
    }

    public void setCpt(int cpt) {
        this.cpt = cpt;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}

