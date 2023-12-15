package io.github.arnascizi.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.arnascizi.api.bl.dto.PublisherDto;
import io.github.arnascizi.api.bl.service.PublisherService;
import lombok.RequiredArgsConstructor;

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
