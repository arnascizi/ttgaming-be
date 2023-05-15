package io.github.arnascizi.bl.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.github.arnascizi.bl.repository.PublisherRepository;
import io.github.arnascizi.model.Publisher;

@Component
@Transactional
public class PublisherRepositoryImpl extends SimpleJpaRepository<Publisher, Long> implements PublisherRepository {

    @PersistenceContext
    private EntityManager em;

    public PublisherRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Publisher.class, entityManager), entityManager);
    }
}
