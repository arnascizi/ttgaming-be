package io.github.arnascizi.bl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.arnascizi.bl.dto.DesignerDto;
import io.github.arnascizi.bl.repository.impl.DesignerRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DesignerService {

    private final DesignerRepositoryImpl designerRepository;

    public List<DesignerDto> getAllDesigners() {
        return designerRepository.findAll().stream()
                .map(DesignerDto::of)
                .collect(Collectors.toList());
    }
}
