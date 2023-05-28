package io.github.arnascizi.bl.dto;

import io.github.arnascizi.model.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {

    private Long id;
    private String name;
    private String description;
    private String imgUrl;
    private String duration;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer minAge;
    private Integer releaseYear;
    private Double rating;
    private List<ExpansionDto> expansions = new ArrayList<>();
    private List<DesignerDto> designers = new ArrayList<>();
    private List<ReviewDto> reviews = new ArrayList<>();
    private List<PublisherDto> publishers = new ArrayList<>();
    private List<MechanicDto> mechanics = new ArrayList<>();
    private List<CategoryDto> categories = new ArrayList<>();

    public static GameDto of(Game game) {
        return GameDto.builder()
                .id(game.getId())
                .name(game.getGameName())
                .description(game.getDescription())
                .imgUrl(game.getImageUrl())
                .duration(game.getDuration())
                .minAge(game.getMinAge())
                .minPlayers(game.getMinPlayers())
                .maxPlayers(game.getMaxPlayers())
                .releaseYear(game.getReleaseYear())
                .rating(game.getRating())
                .expansions(game.getExpansions().stream()
                        .map(ExpansionDto::of)
                        .collect(Collectors.toList()))
                .reviews(game.getReviews().stream()
                        .map(ReviewDto::of)
                        .collect(Collectors.toList()))
                .designers(game.getGameDesigners().stream()
                        .map(DesignerDto::of)
                        .collect(Collectors.toList()))
                .categories(game.getGameCategories().stream()
                        .map(CategoryDto::of)
                        .collect(Collectors.toList()))
                .mechanics(game.getGameMechanics().stream()
                        .map(MechanicDto::of)
                        .collect(Collectors.toList()))
                .publishers(game.getGamePublishers().stream()
                        .map(PublisherDto::of)
                        .collect(Collectors.toList()))
                .build();
    }
}
