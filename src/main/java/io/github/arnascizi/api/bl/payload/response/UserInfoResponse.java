package io.github.arnascizi.api.bl.payload.response;

import java.time.LocalDateTime;
import java.util.List;

import io.github.arnascizi.api.bl.dto.GameDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoResponse {

    private Long id;
    private String username;
    private String email;
    protected String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<GameDto> userCollection;
    private List<GameDto> userWishlist;
}
