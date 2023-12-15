package io.github.arnascizi.api.bl.dto;

import io.github.arnascizi.api.model.Mechanic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MechanicDto {

    private Long id;
    private String name;

    public static MechanicDto of(Mechanic mechanic) {
        return MechanicDto.builder()
                .id(mechanic.getId())
                .name(mechanic.getName())
                .build();
    }
}
