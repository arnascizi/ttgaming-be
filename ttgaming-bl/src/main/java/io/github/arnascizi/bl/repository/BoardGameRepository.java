package io.github.arnascizi.bl.repository;

import io.github.arnascizi.bl.dto.GameSearch;
import io.github.arnascizi.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BoardGameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllGames();

    List<Game> getAllGames(GameSearch search);

    List<Game> getTopGames();

    Game getGameById(Long id);
}
