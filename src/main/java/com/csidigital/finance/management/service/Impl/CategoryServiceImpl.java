package com.csidigital.finance.management.service.Impl;


import com.csidigital.finance.dao.entity.Category;
import com.csidigital.finance.dao.entity.Treasury;
import com.csidigital.finance.dao.repository.CategoryRepository;
import com.csidigital.finance.dao.repository.TreasuryRepository;
import com.csidigital.finance.management.service.CategoryService;
import com.csidigital.finance.shared.dto.Request.CategoryDtoRequest;
import com.csidigital.finance.shared.dto.Response.CategoryDtoResponse;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TreasuryRepository treasuryRepository ;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDtoResponse> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDtoResponse> categoryList = new ArrayList<>();

        for (Category category : categories) {
            CategoryDtoResponse categoryDtoResponse = modelMapper.map(category, CategoryDtoResponse.class);
            categoryList.add(categoryDtoResponse);
        }

        return categoryList;    }

    @Override
    public CategoryDtoResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category with id " +id+ " not found"));
        CategoryDtoResponse categoryDtoResponse = modelMapper.map(category, CategoryDtoResponse.class);
        return categoryDtoResponse;
    }

    @Override
    public CategoryDtoResponse CreateCategory(CategoryDtoRequest categoryDtoRequest) {
        Category category = modelMapper.map(categoryDtoRequest, Category.class);
        Treasury treasury = treasuryRepository.findById(categoryDtoRequest.getTreasuryId()).orElseThrow();
        category.setTreasury(treasury);
        Category CategorySaved = categoryRepository.save(category);
        return modelMapper.map(CategorySaved, CategoryDtoResponse.class);
    }

    @Override
    public CategoryDtoResponse updateCategory(CategoryDtoRequest categoryDtoRequest, Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category with id: " + id + " not found"));
        modelMapper.map(categoryDtoRequest, category);
        Category updatedCategory = categoryRepository.save(category);
        return modelMapper.map(updatedCategory, CategoryDtoResponse.class);    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);

    }

}
