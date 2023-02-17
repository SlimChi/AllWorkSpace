package fr.cs.sdbm_jee.converter;

import fr.cs.sdbm_jee.bean.SdbmBean;
import fr.cs.sdbm_jee.metier.Fabricant;
import fr.cs.sdbm_jee.metier.Marque;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "marqueConverter", managed = true)
public class MarqueConverter implements Converter {
    @Inject
    private SdbmBean sdbmBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Marque marque : sdbmBean.getAllMarques()){
                if(marque.getId() == Integer.parseInt(value)){
                    return marque;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Marque marque = (Marque) object;
        return String.valueOf(marque.getId());
    }
}
