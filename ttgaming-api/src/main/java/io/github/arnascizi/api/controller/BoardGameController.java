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

import io.github.arnascizi.api.helper.Endpoint;
import io.github.arnascizi.bl.dto.GameDto;
import io.github.arnascizi.bl.dto.GameSearch;
import io.github.arnascizi.bl.dto.ReviewDto;
import io.github.arnascizi.bl.service.BoardGameService;
import io.github.arnascizi.bl.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

@RestController
@RequestMapping(Endpoint.TTGAMES)
@RequiredArgsConstructor
@CommonsLog
public class BoardGameController {

    private final BoardGameService boardGameService;
    private final ReviewsService reviewsService;

    @GetMapping(Endpoint.TOP_GAMES)
    public ResponseEntity<List<GameDto>> getTopGames() {
        return new ResponseEntity<>(boardGameService.getTopGames(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GameDto>> getAllGames() {
        return new ResponseEntity<>(boardGameService.getAllGamesList(), HttpStatus.OK);
    }

    @PostMapping(Endpoint.SEARCH)
    public ResponseEntity<List<GameDto>> getAllBoardGames(@RequestBody GameSearch search) {
        return new ResponseEntity<>(boardGameService.getAllGames(search), HttpStatus.OK);
    }

    @GetMapping(Endpoint.ID)
    public ResponseEntity<GameDto> getSingleGame(@PathVariable("id") String id) {
        GameDto game = boardGameService.getGameById(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping(Endpoint.GAME_REVIEWS)
    public ResponseEntity<List<ReviewDto>> getGameReviews(@PathVariable Long id) {
        return new ResponseEntity<>(reviewsService.getAllGameReviews(id), HttpStatus.OK);
    }

    @PostMapping(Endpoint.NEW)
    public ResponseEntity<Void> addNewBoardGame(@RequestBody GameDto gameDto) {
        boardGameService.createGame(gameDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(Endpoint.ID)
    public ResponseEntity<Void> deleteGameById(@PathVariable Long id) {
        boardGameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}
