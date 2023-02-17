package fr.cs.sdbm_jee.converter;

import fr.cs.sdbm_jee.bean.SdbmBean;
import fr.cs.sdbm_jee.metier.Continent;
import fr.cs.sdbm_jee.metier.Fabricant;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "continentConverter", managed = true)
public class ContinentConverter implements Converter {
    @Inject
    private SdbmBean sdbmBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Continent continent : sdbmBean.getAllContinent()){
                if(continent.getId() == Integer.parseInt(value)){
                    return continent;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Continent continent = (Continent) object;
        return String.valueOf(continent.getId());
    }
}
