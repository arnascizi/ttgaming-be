package io.github.arnascizi.api.bl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.arnascizi.api.bl.dto.GameSearch;
import io.github.arnascizi.api.model.Game;

@NoRepositoryBean
public interface BoardGameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllGames();

    List<Game> getAllGames(GameSearch search);

    List<Game> getTopGames();

    Game getGameById(Long id);
}
