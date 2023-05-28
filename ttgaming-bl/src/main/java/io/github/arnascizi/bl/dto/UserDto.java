package io.github.arnascizi.bl.dto;

import io.github.arnascizi.model.TtgUser;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String username;

    public static UserDto of(TtgUser user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
