package io.github.arnascizi.bl.service;

import io.github.arnascizi.bl.dto.ReviewDto;
import io.github.arnascizi.bl.payload.request.ReviewRequest;
import io.github.arnascizi.bl.repository.impl.BoardGameRepositoryImpl;
import io.github.arnascizi.bl.repository.impl.ReviewsRepositoryImpl;
import io.github.arnascizi.bl.repository.impl.UserRepositoryImpl;
import io.github.arnascizi.model.Game_;
import io.github.arnascizi.model.Review;
import io.github.arnascizi.model.Review_;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReviewsService {

    private final ReviewsRepositoryImpl reviewsRepository;
    private final BoardGameRepositoryImpl gameRepository;
    private final UserRepositoryImpl userRepository;

    public List<ReviewDto> getAllGameReviews(Long gameId) {
        return reviewsRepository.findAll((root, query, cb) -> cb.equal(root.get(Review_.game).get(Game_.id), gameId)).stream()
                .map(ReviewDto::of)
                .collect(Collectors.toList());
    }

    public void postReview(ReviewRequest request) {
        reviewsRepository.save(buildReview(request));
    }

    private Review buildReview(ReviewRequest request) {
        return Review.builder()
                .ttgUser(userRepository.getUserByUsername(request.getUsername()))
                .game(gameRepository.getGameById(request.getGameId()))
                .comment(request.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .rating(request.getRating())
                .build();
    }
}
