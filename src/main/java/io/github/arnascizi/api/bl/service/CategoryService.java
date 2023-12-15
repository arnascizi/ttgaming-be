package io.github.arnascizi.api.bl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.arnascizi.api.bl.dto.CategoryDto;
import io.github.arnascizi.api.bl.repository.impl.CategoryRepositoryImpl;
import io.github.arnascizi.api.model.Category;
import io.github.arnascizi.model.Category_;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepositoryImpl  categoryRepository;

    public List<CategoryDto> fetchAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryDto::of).collect(Collectors.toList());
    }

    public CategoryDto fetchSingleCategoryByName(String name) {
        return CategoryDto.of(categoryRepository.findOne((root, query, cb) -> cb.equal(root.get(Category_.name), name)).orElseThrow());
    }

    public void addNewCategory(CategoryDto categoryDto) {
        var category = Category.builder().name(categoryDto.getName()).build();
        categoryRepository.save(category);
    }

    public void removeCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
