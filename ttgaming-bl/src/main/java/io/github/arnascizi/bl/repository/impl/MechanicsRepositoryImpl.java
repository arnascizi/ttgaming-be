package io.github.arnascizi.bl.repository.impl;

import io.github.arnascizi.model.Mechanic;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class MechanicsRepositoryImpl extends SimpleJpaRepository<Mechanic, Long> {

    @PersistenceContext
    private EntityManager em;

    public MechanicsRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Mechanic.class, entityManager), entityManager);
    }
}
