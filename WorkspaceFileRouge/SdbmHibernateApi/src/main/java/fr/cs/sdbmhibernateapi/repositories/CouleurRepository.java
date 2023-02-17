package fr.cs.sdbmhibernateapi.repositories;

import fr.cs.sdbmhibernateapi.entities.CouleurEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

public class CouleurRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("fr.cs.sdbm").createEntityManager();


    public List<CouleurEntity> getAll() {
        return entityManager.createNamedQuery("couleur.getAll", CouleurEntity.class).getResultList();
    }

    public CouleurEntity getById(int id) {
        CouleurEntity couleur = entityManager.find(CouleurEntity.class, id);
        return couleur;
    }

    @Transactional
    public boolean update(CouleurEntity couleur) {

        CouleurEntity updatingCouleur = getById(couleur.getIdCouleur());
        if (updatingCouleur == null) return false;
        entityManager.getTransaction().begin();
        entityManager.merge(couleur);
        entityManager.getTransaction().commit();
        return true;
    }

    @Transactional
    public void create(CouleurEntity couleur) {
        entityManager.getTransaction().begin();
        entityManager.persist(couleur);
        entityManager.getTransaction().commit();
    }

    @Transactional
    public boolean delete(CouleurEntity couleur) {
        CouleurEntity deletingCouleur = getById(couleur.getIdCouleur());
        if (deletingCouleur == null)
            return false;
        entityManager.getTransaction().begin();
        entityManager.remove(deletingCouleur);
        entityManager.getTransaction().commit();
        return true;
    }
}
