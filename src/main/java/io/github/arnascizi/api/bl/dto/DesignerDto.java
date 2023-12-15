package io.github.arnascizi.api.bl.dto;

import io.github.arnascizi.api.model.Designer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DesignerDto {

    private Long id;
    private String name;
    private String description;
    private String websiteUrl;

    public static DesignerDto of(Designer designer) {
        return DesignerDto.builder()
                .id(designer.getId())
                .name(designer.getName())
                .description(designer.getDescription())
                .websiteUrl(designer.getWebsiteUrl())
                .build();
    }
}
