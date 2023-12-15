package io.github.arnascizi.api.bl.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {

    private String username;
    private Long gameId;
    private String content;
    private Integer rating;
}
