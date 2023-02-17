package fr.cs.jsf01.converter;

import fr.cs.jsf01.metier.NIR;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

import java.time.LocalDate;
import java.util.Locale;
import java.util.regex.Pattern;

@FacesConverter(value = "nirConverter")
public class NirConverter implements Converter<NIR> {

    @Override
    public NIR getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        s = s.replace(" ","").toUpperCase(Locale.ROOT);
        if(s.length() != 15) errorDetected(new FacesMessage("Erreur de conversion",
                "conversion impossible, veuillez saisir les 13 chiffres plus la clef !"));
        if(!Pattern.matches("[0-9]{6}[0-9,A,B][0-9]{8}",s)) errorDetected(new FacesMessage("Erreur de conversion",
                " Conversion impossible, caractère incorects détectés !"));
        NIR nir = new NIR();
        nir.setSexe((s.substring(0,1)));
        nir.setAnneeNaissance((s.substring(1,3)));
        nir.setMoisNaissance((s.substring(3,5)));
        nir.setLieuNaissance(s.substring(5,10));
        nir.setOrdreNaissance((s.substring(10,13)));
        nir.setCle((s.substring(13,15)));
        if(!nir.isValid()) errorDetected(new FacesMessage("Erreur de Validation", "Le numéro n'est pas valide"));

        return nir;
    }

    private void errorDetected(FacesMessage msg) {
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw  new ConverterException(msg);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, NIR nir) {
        return null;
    }
}
