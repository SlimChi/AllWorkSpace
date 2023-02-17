package fr.cs.sdbm_jee.converter;

import fr.cs.sdbm_jee.bean.SdbmBean;
import fr.cs.sdbm_jee.metier.Couleur;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "couleurConverter", managed = true)
public class CouleurConverter implements Converter {

    @Inject
    private SdbmBean sdbmBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Couleur couleur : sdbmBean.getAllCouleur()){
                if(couleur.getId() == Integer.parseInt(value)){
                    return couleur;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Couleur couleur = (Couleur) object;
        return String.valueOf(couleur.getId());
    }
}
