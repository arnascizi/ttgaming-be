package io.github.arnascizi.bl.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.github.arnascizi.bl.repository.BoardGameRepository;
import io.github.arnascizi.model.Game;
import io.github.arnascizi.model.Game_;

@Component
@Transactional
public class BoardGameRepositoryImpl extends SimpleJpaRepository<Game, Long> implements BoardGameRepository {

    @PersistenceContext
    private EntityManager em;

    public BoardGameRepositoryImpl(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Game.class, entityManager), entityManager);
    }

    @Override
    public List<Game> findAllGames() {
        return findAll((root, query, cb) -> cb.isNotNull(root.get(Game_.id)));
    }

    // TODO lookup dependencies
    // private Specifications<Game> buildSpecifications() {
    //     Specifications<Game> specifications = Specifications.where(null);
    //     return specifications;
    // }
}
