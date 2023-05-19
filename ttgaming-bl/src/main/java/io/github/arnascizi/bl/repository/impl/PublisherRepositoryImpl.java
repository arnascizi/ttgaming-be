package io.github.arnascizi.bl.repository.impl;

import io.github.arnascizi.model.Publisher;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class PublisherRepositoryImpl extends SimpleJpaRepository<Publisher, Long> {

    @PersistenceContext
    private EntityManager em;

    public PublisherRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Publisher.class, entityManager), entityManager);
    }
}
