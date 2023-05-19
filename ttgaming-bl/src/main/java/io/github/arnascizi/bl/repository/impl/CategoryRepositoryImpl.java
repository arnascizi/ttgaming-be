package io.github.arnascizi.bl.repository.impl;

import io.github.arnascizi.model.Category;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class CategoryRepositoryImpl extends SimpleJpaRepository<Category, Long> {

    @PersistenceContext
    private EntityManager em;

    public CategoryRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Category.class, entityManager), entityManager);
    }
}
