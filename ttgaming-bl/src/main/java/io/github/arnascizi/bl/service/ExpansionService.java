package io.github.arnascizi.bl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.arnascizi.bl.dto.ExpansionDto;
import io.github.arnascizi.bl.repository.impl.ExpansionRepositoryImpl;
import io.github.arnascizi.model.Expansion;
import io.github.arnascizi.model.Expansion_;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExpansionService {

    private final ExpansionRepositoryImpl expansionRepository;

    public List<ExpansionDto> fetchExpansions() {
        return expansionRepository.findAll().stream().map(ExpansionDto::of).collect(Collectors.toList());
    }

    public ExpansionDto fetchExpansionByName(String name) {
        return ExpansionDto.of(expansionRepository.findOne((root, query, cb) -> cb.equal(root.get(Expansion_.name), name)).orElseThrow());
    }

    public List<ExpansionDto> fetchExpansionsByGameId(@NonNull String gameId) {
        return expansionRepository.findAll((root, query, cb) ->
                cb.equal(root.get(Expansion_.baseGameId), Long.valueOf(gameId))).stream()
                .map(ExpansionDto::of)
                .collect(Collectors.toList());
    }
    public void addNewExpansion(ExpansionDto dto) {
        var expansion = Expansion.builder()
                .name(dto.getName())
                .build();
        expansionRepository.save(expansion);
    }

    public void removeExpansionById(Long id) {
        expansionRepository.deleteById(id);
    }
}
