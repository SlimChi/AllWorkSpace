package fr.cs.sdbm_jee.converter;

import fr.cs.sdbm_jee.bean.SdbmBean;
import fr.cs.sdbm_jee.metier.Fabricant;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "fabricantConverter", managed = true)
public class FabricantConverter implements Converter {

    @Inject
    private SdbmBean sdbmBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Fabricant fabricant : sdbmBean.getAllFabricant()){
                if(fabricant.getId() == Integer.parseInt(value)){
                    return fabricant;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Fabricant fabricant = (Fabricant) object;
        return String.valueOf(fabricant.getId());
    }
}
