package fr.cs.sdbm_jee.bean;

import fr.cs.sdbm_jee.dao.DaoFactory;
import fr.cs.sdbm_jee.metier.*;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.util.LangUtils;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.*;

import static java.lang.Integer.getInteger;

@Named
@SessionScoped
public class SdbmBean implements Serializable {

    private static ArrayList<Couleur> allCouleur;
    private Couleur couleurSelected;

    private static ArrayList<Fabricant> allFabricant;
    private Fabricant fabricantSelected;
    private static ArrayList<TypeBiere> allTypeBiere;
    private TypeBiere typeBiereSelected;

    private static ArrayList<Pays> allPays;
    private Pays paysSelected;

    private static ArrayList<Continent> allContinent;
    private Continent continentSelected;

    private static ArrayList<Marque> allMarques;
    private Marque marqueSelected;


    private ArticleSearch articleSearch;
    private ServiceArticle serviceArticle;
    private ArrayList<Article> allArticls;
    private ArrayList<Article> allArticlesSelected;
    private Article articleSelected;


    @PostConstruct
    private void init() {

        allCouleur = serviceArticle.getCouleurFiltre();
        allFabricant = serviceArticle.getFabricantFiltre();
        allTypeBiere = serviceArticle.getTypeBiereFiltre();
        allPays = serviceArticle.getPaysFiltre();
        allContinent = serviceArticle.getContinentFiltre();
        allMarques = serviceArticle.getMarqueFiltre();

        allArticls = serviceArticle.getFilteredArticles(articleSearch);
    }

    public SdbmBean() {

        articleSearch = new ArticleSearch();
        serviceArticle = new ServiceArticle();
        articleSearch.setLibelle("");
        articleSearch.setTitrageMin(0);
        articleSearch.setTitrageMax(26);

        articleSelected = new Article();
        allArticls = serviceArticle.getFilteredArticles(articleSearch);
    }

    public void filtrer() {

        articleSearch = new ArticleSearch();
        serviceArticle = new ServiceArticle();
        articleSearch.setLibelle("");
        articleSearch.setTitrageMin(0);
        articleSearch.setTitrageMax(26);
        articleSearch.setCouleur(couleurSelected);
        articleSearch.setPays(paysSelected);
        articleSearch.setContinent(continentSelected);
        articleSearch.setFabricant(fabricantSelected);
        articleSearch.setMarque(marqueSelected);
        articleSearch.setTypeBiere(typeBiereSelected);

        allArticls = serviceArticle.getFilteredArticles(articleSearch);

    }

    public void onContinentChange() {
        if (continentSelected.getId() != 0) {

            allPays = DaoFactory.getPaysDAO().getByContinent(continentSelected.getId());

        } else {
            allPays = DaoFactory.getPaysDAO().getAll();
            Pays pays = new Pays();
            pays.setLibelle("Choisir un pays");
            allPays.add(0, pays);
        }
    }

    public void onPaysChange() {
        if (paysSelected.getId() != 0) {

            continentSelected = DaoFactory.getContinentDAO().getByID(paysSelected.getContinent().getId());
            allContinent = new ArrayList<>();
            allContinent.add(paysSelected.getContinent());

        } else {

            allContinent = DaoFactory.getContinentDAO().getAll();
            Continent continent = new Continent(0, "Choisir un continent");
            allContinent.add(0, continent);


        }
    }

    public void reset() {

        init();
        articleSearch = new ArticleSearch();
        articleSearch.setLibelle("");
        articleSearch.setTitrageMin(0);
        articleSearch.setTitrageMax(26);
        allArticls = serviceArticle.getFilteredArticles(articleSearch);


    }


    public ArrayList<Couleur> getAllCouleur() {
        return allCouleur;
    }

    public Couleur getCouleurSelected() {
        return couleurSelected;
    }

    public void setCouleurSelected(Couleur couleurSelected) {
        this.couleurSelected = couleurSelected;
    }

    public ArrayList<Fabricant> getAllFabricant() {
        return allFabricant;
    }

    public Fabricant getFabricantSelected() {
        return fabricantSelected;
    }

    public void setFabricantSelected(Fabricant fabricantSelected) {
        this.fabricantSelected = fabricantSelected;
    }

    public ArrayList<TypeBiere> getAllTypeBiere() {
        return allTypeBiere;
    }

    public TypeBiere getTypeBiereSelected() {
        return typeBiereSelected;
    }

    public void setTypeBiereSelected(TypeBiere typeBiereSelected) {
        this.typeBiereSelected = typeBiereSelected;
    }

    public ArrayList<Pays> getAllPays() {
        return allPays;
    }

    public Pays getPaysSelected() {

        return paysSelected;
    }

    public void setPaysSelected(Pays paysSelected) {
        this.paysSelected = paysSelected;
    }

    public ArrayList<Continent> getAllContinent() {
        return allContinent;
    }

    public Continent getContinentSelected() {
        return continentSelected;
    }

    public void setContinentSelected(Continent continentSelected) {
        this.continentSelected = continentSelected;
    }

    public ArrayList<Marque> getAllMarques() {
        return allMarques;
    }

    public Marque getMarqueSelected() {
        return marqueSelected;
    }

    public void setMarqueSelected(Marque marqueSelected) {
        this.marqueSelected = marqueSelected;
    }

    public ArticleSearch getArticleSearch() {
        return articleSearch;
    }

    public void setArticleSearch(ArticleSearch articleSearch) {
        this.articleSearch = articleSearch;
    }

    public ServiceArticle getServiceArticle() {
        return serviceArticle;
    }

    public void setServiceArticle(ServiceArticle serviceArticle) {
        this.serviceArticle = serviceArticle;
    }

    public ArrayList<Article> getAllArticls() {
        return allArticls;
    }

    public void setAllArticls(ArrayList<Article> allArticls) {
        this.allArticls = allArticls;
    }

    public Article getArticleSelected() {
        return articleSelected;
    }

    public void setArticleSelected(Article articleSelected) {
        this.articleSelected = articleSelected;
    }

    public ArrayList<Article> getAllArticlesSelected() {
        return allArticlesSelected;
    }

    public void setAllArticlesSelected(ArrayList<Article> allArticlesSelected) {
        this.allArticlesSelected = allArticlesSelected;
    }

    public String envoyer() {
        return "envoyerOK";
    }
}
