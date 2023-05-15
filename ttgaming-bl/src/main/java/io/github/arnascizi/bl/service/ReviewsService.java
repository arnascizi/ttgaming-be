package io.github.arnascizi.bl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.arnascizi.bl.dto.ReviewDto;
import io.github.arnascizi.bl.repository.impl.ReviewsRepositoryImpl;
import io.github.arnascizi.model.Game_;
import io.github.arnascizi.model.Review_;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReviewsService {

    private final ReviewsRepositoryImpl reviewsRepository;

    public List<ReviewDto> getAllGameReviews(Long gameId) {
        return reviewsRepository.findAll((root, query, cb) -> cb.equal(root.get(Review_.game).get(Game_.id), gameId)).stream()
                .map(ReviewDto::of)
                .collect(Collectors.toList());
    }
}
