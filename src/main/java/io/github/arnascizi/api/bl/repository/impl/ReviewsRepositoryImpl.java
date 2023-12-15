package io.github.arnascizi.api.bl.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.github.arnascizi.api.model.Review;

@Component
@Transactional
public class ReviewsRepositoryImpl extends SimpleJpaRepository<Review, Long> {

    @PersistenceContext
    private EntityManager em;

    public ReviewsRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Review.class, entityManager), entityManager);
    }
}
