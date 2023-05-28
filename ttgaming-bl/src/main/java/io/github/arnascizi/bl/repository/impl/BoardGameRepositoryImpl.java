package io.github.arnascizi.bl.repository.impl;

import io.github.arnascizi.bl.dto.GameSearch;
import io.github.arnascizi.bl.repository.BoardGameRepository;
import io.github.arnascizi.model.Game;
import io.github.arnascizi.model.Game_;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return findAll();
    }

    @Override
    public List<Game> getAllGames(GameSearch search) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Game> criteria = cb.createQuery(Game.class);
        Root<Game> root = criteria.from(Game.class);

        List<Predicate> predicates = new ArrayList<>();
        if (!StringUtils.isBlank(search.getSearchQuery())) {
            predicates.add(cb.equal(cb.upper(root.get(Game_.gameName)), search.getSearchQuery().toUpperCase()));
        } else {
            predicates.add(cb.notEqual(cb.upper(root.get(Game_.gameName)), search.getSearchQuery().toUpperCase()));
        }

        criteria.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(criteria).getResultList();
    }

    @Override
    public List<Game> getTopGames() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Game> criteria = cb.createQuery(Game.class);
        Root<Game> root = criteria.from(Game.class);

        return em.createQuery(criteria.orderBy(cb.desc(root.get(Game_.rating)))).getResultList().stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public Game getGameById(Long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Game> criteria = cb.createQuery(Game.class);
        Root<Game> root = criteria.from(Game.class);

        criteria.where(cb.equal(root.get(Game_.id), id));

        return em.createQuery(criteria).getSingleResult();
    }
}
