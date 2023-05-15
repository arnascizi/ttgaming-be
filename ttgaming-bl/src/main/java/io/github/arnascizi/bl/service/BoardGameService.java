package io.github.arnascizi.bl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.arnascizi.bl.dto.CategoryDto;
import io.github.arnascizi.bl.dto.DesignerDto;
import io.github.arnascizi.bl.dto.GameDto;
import io.github.arnascizi.bl.dto.MechanicDto;
import io.github.arnascizi.bl.dto.PublisherDto;
import io.github.arnascizi.bl.repository.impl.BoardGameRepositoryImpl;
import io.github.arnascizi.model.Category;
import io.github.arnascizi.model.Designer;
import io.github.arnascizi.model.Game;
import io.github.arnascizi.model.Game_;
import io.github.arnascizi.model.Mechanic;
import io.github.arnascizi.model.Publisher;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BoardGameService {

    private final BoardGameRepositoryImpl boardGameRepository;

    public List<GameDto> getAllGames() {
        return boardGameRepository.findAllGames().stream()
                .map(GameDto::of)
                .collect(Collectors.toList());
    }

    public GameDto getGameById(@NonNull String id) {
        return GameDto.of(boardGameRepository.findOne((root, query, cb) ->
                cb.equal(root.get(Game_.id), Long.valueOf(id))).orElseThrow());
    }

    public void createGame(GameDto dto) {
        boardGameRepository.save(buildGame(dto));
    }

    public void deleteGame(Long id) {
        boardGameRepository.deleteById(id);
    }

    private Game buildGame(GameDto dto) {
        return Game.builder()
                .gameName(dto.getName())
                .description(dto.getDescription())
                .imageUrl(dto.getImgUrl())
                .duration(dto.getDuration())
                .minAge(dto.getMinAge())
                .minPlayers(dto.getMinPlayers())
                .maxPlayers(dto.getMaxPlayers())
                .releaseYear(dto.getReleaseYear())
                .gameCategories(dto.getCategories().stream()
                        .map(this::buildCategory)
                        .collect(Collectors.toUnmodifiableList()))
                .gameMechanics(dto.getMechanics().stream()
                        .map(this::buildMechanic)
                        .collect(Collectors.toUnmodifiableList()))
                .gameDesigners(dto.getDesigners().stream()
                        .map(this::buildDesigner)
                        .collect(Collectors.toUnmodifiableList()))
                .gamePublishers(dto.getPublishers().stream()
                        .map(this::buildPublisher)
                        .collect(Collectors.toUnmodifiableList()))
                .rating(0.00D)
                .build();
    }

    private Publisher buildPublisher(PublisherDto dto) {
        return Publisher.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .websiteUrl(dto.getWebsiteUrl())
                .build();
    }

    private Designer buildDesigner(DesignerDto dto) {
        return Designer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .websiteUrl(dto.getWebsiteUrl())
                .build();
    }

    private Mechanic buildMechanic(MechanicDto dto) {
        return Mechanic.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    private Category buildCategory(CategoryDto dto) {
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
