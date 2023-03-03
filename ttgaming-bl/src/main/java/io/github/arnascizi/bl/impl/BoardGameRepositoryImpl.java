package io.github.arnascizi.bl.impl;

import java.util.List;

import io.github.arnascizi.bl.BoardGameRepository;
import io.github.arnascizi.model.BoardGame;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardGameRepositoryImpl {

    private final BoardGameRepository boardGameRepository;

    public List<BoardGame> findAllBoardGames() {
        return boardGameRepository.findAll();
    }
}
