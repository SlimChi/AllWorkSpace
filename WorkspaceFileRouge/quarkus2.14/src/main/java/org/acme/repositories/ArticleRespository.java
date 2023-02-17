package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.ArticleEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

@RequestScoped
@Named("ArticleRepository")
public class ArticleRespository implements PanacheRepositoryBase <ArticleEntity, Integer> {
}
