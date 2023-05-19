package io.github.arnascizi.bl.repository.impl;

import io.github.arnascizi.bl.TtGamingProperties;
import io.github.arnascizi.bl.repository.UserRepository;
import io.github.arnascizi.model.TtgUser;
import io.github.arnascizi.model.TtgUser_;
import lombok.NonNull;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
@Transactional
public class UserRepositoryImpl extends SimpleJpaRepository<TtgUser, Long> implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    public UserRepositoryImpl(EntityManager entityManager, TtGamingProperties gamingProperties) {
        super(JpaEntityInformationSupport.getEntityInformation(TtgUser.class, entityManager), entityManager);
    }

    @Override
    public TtgUser getUserByUsername(@NonNull String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TtgUser> criteria = cb.createQuery(TtgUser.class);
        Root<TtgUser> root = criteria.from(TtgUser.class);

        criteria.where(cb.equal(root.get(TtgUser_.username), username));
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public boolean existsByUsername(@NonNull String username) {
        return findOne(((root, query, cb) -> cb.equal(root.get(TtgUser_.username), username))).isPresent();
    }

    @Override
    public boolean existsByEmail(String email) {
        return findOne(((root, query, cb) -> cb.equal(root.get(TtgUser_.email), email))).isPresent();
    }
}
