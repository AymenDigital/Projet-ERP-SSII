package com.csidigital.finance.management.service;

import com.csidigital.finance.shared.dto.Request.CategoryDtoRequest;
import com.csidigital.finance.shared.dto.Response.CategoryDtoResponse;

import java.util.List;

public interface CategoryService {

    //Get All Category

    List<CategoryDtoResponse> getAllCategory();

    //Get Category by id

    CategoryDtoResponse getCategoryById(Long id);
    //Add new Category

    CategoryDtoResponse CreateCategory(CategoryDtoRequest categoryDtoRequest);

    //Update Category by id
    CategoryDtoResponse updateCategory(CategoryDtoRequest categoryDtoRequest, Long id);

    //delete Category by id
    void deleteCategoryById(Long id);
}
