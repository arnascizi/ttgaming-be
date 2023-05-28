package io.github.arnascizi.api.controller;

import io.github.arnascizi.bl.dto.CategoryDto;
import io.github.arnascizi.bl.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.fetchAllCategories(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addNewCategory() {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
