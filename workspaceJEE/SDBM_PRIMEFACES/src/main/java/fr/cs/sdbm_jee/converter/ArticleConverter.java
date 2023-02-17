package fr.cs.sdbm_jee.converter;

import fr.cs.sdbm_jee.bean.SdbmBean;
import fr.cs.sdbm_jee.metier.Article;
import fr.cs.sdbm_jee.metier.Continent;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "articleConverter", managed = true)
public class ArticleConverter implements Converter {

    @Inject
    private SdbmBean sdbmBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Article article : sdbmBean.getAllArticls()){
                if(article.getId() == Integer.parseInt(value)){
                    return article;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Article article = (Article) object;
        return String.valueOf(article.getId());
    }
}
