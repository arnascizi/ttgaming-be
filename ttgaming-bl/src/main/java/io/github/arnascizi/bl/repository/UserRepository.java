package io.github.arnascizi.bl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.arnascizi.model.TtgUser;

@NoRepositoryBean
public interface UserRepository extends JpaRepository<TtgUser, Long> {
    TtgUser getUserByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
