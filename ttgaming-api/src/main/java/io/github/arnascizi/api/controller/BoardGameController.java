package io.github.arnascizi.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.arnascizi.bl.dto.GameDto;
import io.github.arnascizi.bl.dto.ReviewDto;
import io.github.arnascizi.bl.service.BoardGameService;
import io.github.arnascizi.bl.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
@CommonsLog
public class BoardGameController {

    private final BoardGameService boardGameService;
    private final ReviewsService reviewsService;

    @GetMapping
    public ResponseEntity<List<GameDto>> getAllBoardGames() {
        return new ResponseEntity<>(boardGameService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GameDto> getSingleGame(@PathVariable("id") String id) {
        GameDto game = boardGameService.getGameById(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping("{id}/reviews")
    public ResponseEntity<List<ReviewDto>> getGameReviews(@PathVariable Long id) {
        return new ResponseEntity<>(reviewsService.getAllGameReviews(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> addNewBoardGame(@RequestBody GameDto gameDto) {
        boardGameService.createGame(gameDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteGameById(@PathVariable Long id) {
        boardGameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }

}
