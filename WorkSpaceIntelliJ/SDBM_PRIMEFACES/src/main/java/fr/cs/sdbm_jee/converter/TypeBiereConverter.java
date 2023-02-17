package fr.cs.sdbm_jee.converter;

import fr.cs.sdbm_jee.bean.SdbmBean;
import fr.cs.sdbm_jee.metier.Fabricant;
import fr.cs.sdbm_jee.metier.TypeBiere;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "typeBiereConverter", managed = true)
public class TypeBiereConverter implements Converter {
    @Inject
    private SdbmBean sdbmBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (TypeBiere typeBiere : sdbmBean.getAllTypeBiere()){
                if(typeBiere.getId() == Integer.parseInt(value)){
                    return typeBiere;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        TypeBiere typeBiere = (TypeBiere) object;
        return String.valueOf(typeBiere.getId());
    }
}
