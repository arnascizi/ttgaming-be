package io.github.arnascizi.api.controller;

import io.github.arnascizi.bl.payload.request.ReviewRequest;
import io.github.arnascizi.bl.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewsService reviewsService;

    @PostMapping
    public ResponseEntity<?> postReview(@RequestBody ReviewRequest request) {
        reviewsService.postReview(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
