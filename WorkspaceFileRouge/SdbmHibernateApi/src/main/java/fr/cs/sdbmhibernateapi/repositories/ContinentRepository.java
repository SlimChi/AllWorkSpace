package fr.cs.sdbmhibernateapi.repositories;

import fr.cs.sdbmhibernateapi.dto.ContinentDto;
import fr.cs.sdbmhibernateapi.dto.PaysDto;
import fr.cs.sdbmhibernateapi.entities.ContinentEntity;
import fr.cs.sdbmhibernateapi.entities.PaysEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

public class ContinentRepository {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("fr.cs.sdbm").createEntityManager();


    public List<ContinentDto> getAll() {
        return ContinentDto.toContinentDtoList(entityManager.createNamedQuery("continent.getAll", ContinentEntity.class).getResultList());
    }

    public ContinentDto getById(int id) {
        return new ContinentDto(entityManager.find(ContinentEntity.class, id));
    }

    @Transactional
    public boolean update(ContinentEntity continents) {

        ContinentDto updatingContinent = getById(continents.getIdContinent());
        if (updatingContinent == null) return false;
        entityManager.getTransaction().begin();
        entityManager.merge(continents);
        entityManager.getTransaction().commit();
        return true;
    }

    @Transactional
    public void create(ContinentEntity continents) {
        entityManager.getTransaction().begin();
        entityManager.persist(continents);
        entityManager.getTransaction().commit();
    }

    @Transactional
    public boolean delete(ContinentEntity continents) {
        ContinentDto deletingContinent = getById(continents.getIdContinent());
        if (deletingContinent == null)
            return false;
        entityManager.getTransaction().begin();
        entityManager.remove(deletingContinent);
        entityManager.getTransaction().commit();
        return true;
    }

}
