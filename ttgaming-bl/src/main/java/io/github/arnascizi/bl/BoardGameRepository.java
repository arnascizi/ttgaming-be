package io.github.arnascizi.bl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.arnascizi.model.BoardGame;

@NoRepositoryBean
public interface BoardGameRepository extends JpaRepository<BoardGame, Long> {}
