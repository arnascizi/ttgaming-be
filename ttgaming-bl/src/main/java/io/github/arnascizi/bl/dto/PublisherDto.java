package io.github.arnascizi.bl.dto;

import io.github.arnascizi.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDto {

    private Long id;
    private String name;
    private String description;
    private String websiteUrl;

    public static PublisherDto of(Publisher publisher) {
        return PublisherDto.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .description(publisher.getDescription())
                .websiteUrl(publisher.getWebsiteUrl())
                .build();
    }
}
