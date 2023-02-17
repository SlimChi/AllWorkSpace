package fr.cs.sdbmhibernateapi.repositories;

import fr.cs.sdbmhibernateapi.dto.PaysDto;
import fr.cs.sdbmhibernateapi.entities.CouleurEntity;
import fr.cs.sdbmhibernateapi.entities.PaysEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

public class PaysRepository {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("fr.cs.sdbm").createEntityManager();


    public List<PaysDto> getAll() {
        return PaysDto.toPaysDtoList(entityManager.createNamedQuery("pays.getAll", PaysEntity.class).getResultList());
    }

    public PaysDto getById(int id) {
        return new PaysDto(entityManager.find(PaysEntity.class, id));
    }

    @Transactional
    public boolean update(PaysEntity pays) {

        PaysDto updatingPays = getById(pays.getIdPays());
        if (updatingPays == null) return false;
        entityManager.getTransaction().begin();
        entityManager.merge(pays);
        entityManager.getTransaction().commit();
        return true;
    }

    @Transactional
    public void create(PaysEntity pays) {
        entityManager.getTransaction().begin();
        entityManager.persist(pays);
        entityManager.getTransaction().commit();
    }

    @Transactional
    public boolean delete(PaysEntity pays) {
        PaysDto deletingPays = getById(pays.getIdPays());
        if (deletingPays == null)
            return false;
        entityManager.getTransaction().begin();
        entityManager.remove(deletingPays);
        entityManager.getTransaction().commit();
        return true;
    }
}
