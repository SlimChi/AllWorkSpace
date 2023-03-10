package fr.cs.sdbm_jee.converter;

import fr.cs.sdbm_jee.bean.SdbmBean;
import fr.cs.sdbm_jee.metier.Continent;
import fr.cs.sdbm_jee.metier.Pays;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "paysConverter", managed = true)
public class PaysConverter implements Converter {
    @Inject
    private SdbmBean sdbmBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Pays pays : sdbmBean.getAllPays()){
                if(pays.getId() == Integer.parseInt(value)){
                    return pays;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Pays pays = (Pays) object;
        return String.valueOf(pays.getId());
    }
}
