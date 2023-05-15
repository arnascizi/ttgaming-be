package io.github.arnascizi.bl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.arnascizi.model.Game;

@NoRepositoryBean
public interface BoardGameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllGames();
}
