package io.github.arnascizi.bl.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.github.arnascizi.bl.repository.ExpansionRepository;
import io.github.arnascizi.model.Expansion;

@Component
@Transactional
public class ExpansionRepositoryImpl extends SimpleJpaRepository<Expansion, Long> {

    @PersistenceContext
    private EntityManager em;

    public ExpansionRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Expansion.class, entityManager), entityManager);
    }
}
