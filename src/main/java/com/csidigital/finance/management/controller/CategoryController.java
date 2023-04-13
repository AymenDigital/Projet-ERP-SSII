package com.csidigital.finance.management.controller;

import com.csidigital.finance.management.service.CategoryService;
import com.csidigital.finance.shared.dto.Request.BillDtoRequest;
import com.csidigital.finance.shared.dto.Request.CategoryDtoRequest;
import com.csidigital.finance.shared.dto.Response.BillDtoResponse;
import com.csidigital.finance.shared.dto.Response.CategoryDtoResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/fm/categories")
@CrossOrigin("*")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<CategoryDtoResponse> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryDtoResponse getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping()
    public CategoryDtoResponse createCategory(@Valid @RequestBody CategoryDtoRequest categoryDtoRequest){
        return categoryService.CreateCategory(categoryDtoRequest);
    }

    @PutMapping("/{id}")
    public CategoryDtoResponse updateCategory(@Valid @RequestBody  CategoryDtoRequest categoryDtoRequest, @PathVariable Long id){
        return categoryService.updateCategory(categoryDtoRequest, id);
    }


    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }
}

