package fr.repositories;

import fr.entities.CouleurEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CouleurRepository implements PanacheRepositoryBase<CouleurEntity, Integer> {
}
