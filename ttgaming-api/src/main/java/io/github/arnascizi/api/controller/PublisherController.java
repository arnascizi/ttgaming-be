package io.github.arnascizi.api.controller;

import io.github.arnascizi.bl.dto.PublisherDto;
import io.github.arnascizi.bl.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<PublisherDto>> getAllPublishers() {
        return new ResponseEntity<>(publisherService.getAllPublishers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addNewPublisher() {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
