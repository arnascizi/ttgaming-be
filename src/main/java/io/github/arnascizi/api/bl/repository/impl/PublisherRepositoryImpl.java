package io.github.arnascizi.api.bl.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.github.arnascizi.api.model.Publisher;

@Component
@Transactional
public class PublisherRepositoryImpl extends SimpleJpaRepository<Publisher, Long> {

    @PersistenceContext
    private EntityManager em;

    public PublisherRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Publisher.class, entityManager), entityManager);
    }
}
