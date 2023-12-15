package io.github.arnascizi.api.bl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.arnascizi.api.bl.dto.MechanicDto;
import io.github.arnascizi.api.bl.repository.impl.MechanicsRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MechanicService {

    private final MechanicsRepositoryImpl mechanicsRepository;

    public List<MechanicDto> getAllMechanics() {
        return mechanicsRepository.findAll().stream()
                .map(MechanicDto::of)
                .collect(Collectors.toList());
    }
}
