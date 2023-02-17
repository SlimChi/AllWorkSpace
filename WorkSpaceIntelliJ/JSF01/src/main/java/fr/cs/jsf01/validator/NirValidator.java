package fr.cs.jsf01.validator;

import fr.cs.jsf01.metier.NIR;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator(value = "nirValidator")
public class NirValidator implements Validator<NIR> {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, NIR nir) throws ValidatorException {
        if (!nir.isValid()){
            FacesMessage msg = new FacesMessage("Erreur de validation", "Le numéro n'est pas valide !");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
