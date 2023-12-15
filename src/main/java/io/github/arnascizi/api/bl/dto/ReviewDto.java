package io.github.arnascizi.api.bl.dto;

import java.time.LocalDateTime;

import io.github.arnascizi.api.model.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Long id;
    private String content;
    private Integer rating;
    private LocalDateTime createdAt;
    private UserDto user;

    public static ReviewDto of(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .content(review.getComment())
                .user(UserDto.of(review.getTtgUser()))
                .build();
    }
}
