package io.github.arnascizi.bl.payload.response;

import io.github.arnascizi.bl.dto.GameDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
