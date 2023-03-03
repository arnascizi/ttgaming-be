package io.github.arnascizi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.arnascizi.bl.impl.BoardGameRepositoryImpl;
import lombok.RequiredArgsConstructor;

@RequestMapping("/board-game/")
@RequiredArgsConstructor
public class BoardGameController {

    private final BoardGameRepositoryImpl boardGameRepository;

    @GetMapping("/findAll")
    public String getAllBoardGames() {
        return boardGameRepository.findAllBoardGames().toString();
    }
}
