package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.CouleurEntity;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CouleurRepository implements PanacheRepositoryBase<CouleurEntity, Integer> {
}
