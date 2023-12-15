package io.github.arnascizi.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.arnascizi.api.bl.dto.MechanicDto;
import io.github.arnascizi.api.bl.service.MechanicService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mechanics")
public class MechanicController {

    private final MechanicService mechanicsService;

    @GetMapping
    public ResponseEntity<List<MechanicDto>> getAllMechanics() {
        return new ResponseEntity<>(mechanicsService.getAllMechanics(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addNewMechanic() {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
