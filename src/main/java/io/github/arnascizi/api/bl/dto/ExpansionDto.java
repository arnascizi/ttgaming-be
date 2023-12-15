package io.github.arnascizi.api.bl.dto;

import io.github.arnascizi.api.model.Expansion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExpansionDto {

    private Long id;
    private String name;
    private String description;
    private Integer releaseDate;
    private String imgUrl;

    public static ExpansionDto of(Expansion expansion) {
        return ExpansionDto.builder()
                .id(expansion.getId())
                .name(expansion.getName())
                .description(expansion.getDescription())
                .releaseDate(expansion.getReleaseDate())
                .imgUrl(expansion.getImageUrl())
                .build();
    }
}
