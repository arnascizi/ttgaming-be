package io.github.arnascizi.bl.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.github.arnascizi.bl.repository.CategoryRepository;
import io.github.arnascizi.model.Category;

@Component
@Transactional
public class CategoryRepositoryImpl extends SimpleJpaRepository<Category, Long> implements CategoryRepository {

    @PersistenceContext
    private EntityManager em;

    public CategoryRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Category.class, entityManager), entityManager);
    }
}
