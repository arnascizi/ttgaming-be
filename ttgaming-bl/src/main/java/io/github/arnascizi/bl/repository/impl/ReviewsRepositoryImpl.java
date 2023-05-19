package io.github.arnascizi.bl.repository.impl;

import io.github.arnascizi.model.Review;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class ReviewsRepositoryImpl extends SimpleJpaRepository<Review, Long> {

    @PersistenceContext
    private EntityManager em;

    public ReviewsRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Review.class, entityManager), entityManager);
    }
}
