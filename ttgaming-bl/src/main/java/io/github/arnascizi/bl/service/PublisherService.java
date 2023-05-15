package io.github.arnascizi.bl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.arnascizi.bl.dto.PublisherDto;
import io.github.arnascizi.bl.repository.impl.PublisherRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepositoryImpl publisherRepository;

    public List<PublisherDto> getAllPublishers() {
        return publisherRepository.findAll().stream()
                .map(PublisherDto::of)
                .collect(Collectors.toList());
    }
}
