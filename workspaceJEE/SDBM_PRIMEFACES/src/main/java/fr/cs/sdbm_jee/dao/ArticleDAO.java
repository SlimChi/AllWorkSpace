package fr.cs.sdbm_jee.dao;

import fr.cs.sdbm_jee.metier.*;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArticleDAO extends DAO<Article, ArticleSearch>{



    public ArticleDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public ArrayList<Article> getLike(ArticleSearch articleSearch) {
        ResultSet rs;
        ArrayList<Article> liste = new ArrayList<>();
        String procedureStockee = "{call dbo.SP_ARTICLE_QBE (?,?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement cStmt = this.connexion.prepareCall(procedureStockee))
        {

            cStmt.setString(1,articleSearch.getLibelle());
            cStmt.setInt(2 ,articleSearch.getCouleur().getId());
            cStmt.setInt(3,articleSearch.getTypeBiere().getId());
            cStmt.setInt(4,articleSearch.getPays().getId());
            cStmt.setInt(5,articleSearch.getContinent().getId());
            cStmt.setInt(6,articleSearch.getVolume());
            cStmt.setInt(7,articleSearch.getMarque().getId());
            cStmt.setInt(8,articleSearch.getFabricant().getId());
            cStmt.setFloat(9, (float) articleSearch.getTitrageMin());
            cStmt.setFloat(10, (float) articleSearch.getTitrageMax());


            cStmt.execute();
            rs = cStmt.getResultSet();

            while (rs.next())
            {
                // création d'un nouveal article à partir d'une ligne du resultset
                Article newArticle = new Article(rs.getInt(3),(rs.getString(4)));
                newArticle.setPrixAchat(rs.getFloat(5));
                newArticle.setVolume(rs.getInt(6));
                newArticle.setTitrage(rs.getFloat(7));
                newArticle.setCouleur(new Couleur(rs.getInt(8),rs.getString(9)));
                newArticle.setTypeBiere(new TypeBiere(rs.getInt(1),rs.getString(2)));

                Marque newMarque = new Marque();

                newMarque.setId(rs.getInt(15));
                newMarque.setLibelle(rs.getString(14));
                newMarque.setPays(new Pays(rs.getInt(10), rs.getString(11), new Continent(rs.getInt(12), rs.getString(13))));

                newMarque.setFabricant(new Fabricant(rs.getInt(16),rs.getString(17)));


                newArticle.setMarque(newMarque);
                newArticle.setStock(rs.getInt(18));
                liste.add(newArticle);



            }
            rs.close();
        }

        // Handle any errors that may have occurred.
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return liste;
    }
    @Override
    public ArrayList<Article> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Article getByID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(Article article) {
        String Statement = "INSERT INTO ARTICLE (NOM_ARTICLE,PRIX_ACHAT,VOLUME,TITRAGE,ID_MARQUE,ID_COULEUR,ID_TYPE,STOCk) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement))
        {
            pStmt.setString(1,article.getLibelle());
            pStmt.setFloat(2,article.getPrixAchat());
            pStmt.setInt(3,article.getVolume());
            pStmt.setFloat(4,article.getTitrage());
            pStmt.setInt(5,article.getMarque().getId());
            pStmt.setInt(6,article.getCouleur().getId());
            pStmt.setInt(7,article.getTypeBiere().getId());
            pStmt.setInt(8,article.getStock());

            pStmt.execute();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(Article article) {
        String Statement ="UPDATE ARTICLE SET NOM_ARTICLE = ?, PRIX_ACHAT = ?, VOLUME=?,TITRAGE=?,ID_MARQUE =?, ID_COULEUR =?,ID_TYPE=?,STOCK =? WHERE ID_ARTICLE =?";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement))
        {
            pStmt.setString(1,article.getLibelle());
            pStmt.setFloat(2,article.getPrixAchat());
            pStmt.setInt(3,article.getVolume());
            pStmt.setFloat(4,article.getTitrage());
            pStmt.setInt(5,article.getMarque().getId());
            pStmt.setInt(6,article.getCouleur().getId());
            pStmt.setInt(7,article.getTypeBiere().getId());
            pStmt.setInt(8,article.getStock());
            pStmt.setInt(9,article.getId());

            pStmt.execute();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Article article) {
        String Statement = "DELETE FROM ARTICLE WHERE ID_ARTICLE =?";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement))
        {
            pStmt.setInt(1,article.getId());
            pStmt.execute();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();

            return false;
        }

    }
}
