package io.github.arnascizi.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.arnascizi.api.bl.dto.DesignerDto;
import io.github.arnascizi.api.bl.service.DesignerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/designers")
public class DesignerController {

    private final DesignerService designerService;

    @GetMapping
    public ResponseEntity<List<DesignerDto>> getAllCategories() {
        return new ResponseEntity<>(designerService.getAllDesigners(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addNewDesigner() {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
