package fr.cs.sdbm_jee.bean;

import fr.cs.sdbm_jee.metier.Imc;
import fr.cs.sdbm_jee.metier.NIR;
import fr.cs.sdbm_jee.metier.Personne;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.Date;

@Named/*("bean")*/
@RequestScoped
public class Bean {
    private Date localDate;

    private Imc imc;
    private Personne personne;
    private NIR nir;

    public Bean() {
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
//    public String returnAction() {
//        System.out.println( "in returnAction" );
//        return imc.getImcValue().equals(getImc()) ? "success" : "failure";
//    }
}
