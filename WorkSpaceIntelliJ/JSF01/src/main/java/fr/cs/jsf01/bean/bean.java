package fr.cs.jsf01.bean;

import fr.cs.jsf01.metier.Imc;
import fr.cs.jsf01.metier.NIR;
import fr.cs.jsf01.metier.Personne;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.Date;

@RequestScoped
@Named
public class bean {
    private Date localDate;

    private Imc imc;
    private Personne personne;
    private NIR nir;

    public bean() {
        imc = new Imc();
        personne = new Personne();
        nir = new NIR();

    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Imc getImc() {
        return imc;
    }

    public void setImc(Imc imc) {
        this.imc = imc;
    }

    public NIR getNir() {
        return nir;
    }

    public void setNir(NIR nir) {
        this.nir = nir;
    }

    public String envoyer() {
        return "envoyerOK";
    }
}
