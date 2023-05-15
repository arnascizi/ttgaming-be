package io.github.arnascizi.api.controller;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.arnascizi.bl.dto.ExpansionDto;
import io.github.arnascizi.bl.service.ExpansionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/expansions")
public class ExpansionController {

    private final ExpansionService expansionService;

    @GetMapping("{gameId}")
    public ResponseEntity<List<ExpansionDto>> getExpansionsByGameId(@PathVariable String gameId) {
        return new ResponseEntity<>(expansionService.fetchExpansionsByGameId(gameId), HttpStatus.OK);
    }

    @DeleteMapping("{gameId}/remove")
    public ResponseEntity<?> deleteGameById(@PathVariable Long gameId) {
        try {
            expansionService.removeExpansionById(gameId);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
