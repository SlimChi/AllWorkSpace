package fr.ch.repositories;


import fr.ch.entities.CouleurEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("CouleurRepository")
public class CouleurRepository implements PanacheRepositoryBase<CouleurEntity, Integer> {

}
