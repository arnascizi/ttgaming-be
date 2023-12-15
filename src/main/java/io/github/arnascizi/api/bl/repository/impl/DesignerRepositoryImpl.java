package io.github.arnascizi.api.bl.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.github.arnascizi.api.model.Designer;

@Component
@Transactional
public class DesignerRepositoryImpl extends SimpleJpaRepository<Designer, Long> {

    @PersistenceContext
    private EntityManager em;

    public DesignerRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Designer.class, entityManager), entityManager);
    }
}
