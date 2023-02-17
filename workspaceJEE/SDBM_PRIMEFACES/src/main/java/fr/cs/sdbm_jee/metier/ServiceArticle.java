package fr.cs.sdbm_jee.metier;

import fr.cs.sdbm_jee.dao.DaoFactory;

import java.util.ArrayList;

public class ServiceArticle {
    private ArrayList<Pays> paysFiltre;
    private ArrayList<Couleur> couleurFiltre;
    private ArrayList<TypeBiere> typeBiereFiltre;
    private ArrayList<Marque> marqueFiltre;
    private ArrayList<Continent> continentFiltre;
    private ArrayList<Fabricant> fabricantFiltre;

    public ServiceArticle() {
        paysFiltre = DaoFactory.getPaysDAO().getAll();
        Pays pays = new Pays();
        pays.setLibelle("Choisir un pays");
        paysFiltre.add(0,pays);

        continentFiltre = DaoFactory.getContinentDAO().getAll();
        Continent continent= new Continent();
        continent.setLibelle("Choisir un continent");
        continentFiltre.add(0,continent);

        fabricantFiltre = DaoFactory.getFabricantDAO().getAll();
        Fabricant fabricant = new Fabricant();
        fabricant.setLibelle("Choisir un fabricant");
        fabricantFiltre.add(0, fabricant);

        marqueFiltre = DaoFactory.getMarqueDAO().getAll();
        Marque marque = new Marque(0,"Choisir une marque");
        marqueFiltre.add(0,marque);

        couleurFiltre = DaoFactory.getCouleurDAO().getAll();
        Couleur couleur = new Couleur(0,"Choisir une couleur");
        couleurFiltre.add(0,couleur);

        typeBiereFiltre = DaoFactory.getTypeBiereDAO().getAll();
        TypeBiere type = new TypeBiere(0,"Choisir un type");
        typeBiereFiltre.add(0,type);

    }


    public ArrayList<Pays> getPaysFiltre() {
        return paysFiltre;
    }

    public ArrayList<Continent> getContinentFiltre() {
        return continentFiltre;
    }

    public ArrayList<Fabricant> getFabricantFiltre() {
        return fabricantFiltre;
    }

    public ArrayList<Couleur> getCouleurFiltre() {
        return couleurFiltre;
    }

    public ArrayList<TypeBiere> getTypeBiereFiltre() {
        return typeBiereFiltre;
    }

    public ArrayList<Marque> getMarqueFiltre() {
        return marqueFiltre;
    }

    public ArrayList<Article> getFilteredArticles(ArticleSearch articleSearch) {
        return DaoFactory.getArticleDAO().getLike(articleSearch);
    }

    public boolean updateArticle(Article article) {
        return DaoFactory.getArticleDAO().update(article);
    }

    public boolean insertArticle(Article article) {
        return DaoFactory.getArticleDAO().insert(article);
    }

    public boolean deleteArticle(Article article) {
        return DaoFactory.getArticleDAO().delete(article);
    }

}
