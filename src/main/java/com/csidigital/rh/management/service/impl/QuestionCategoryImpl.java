package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Level;
import com.csidigital.rh.dao.entity.QuestionCategory;
import com.csidigital.rh.dao.entity.Resource;
import com.csidigital.rh.dao.entity.TechnicalFile;
import com.csidigital.rh.dao.repository.LevelRespository;
import com.csidigital.rh.dao.repository.QuestionCategoryRepository;
import com.csidigital.rh.management.service.QuestionCategoryService;
import com.csidigital.rh.shared.dto.request.QuestionCategoryRequest;
import com.csidigital.rh.shared.dto.request.ResourceRequest;
import com.csidigital.rh.shared.dto.response.QuestionCategoryResponse;
import com.csidigital.rh.shared.dto.response.ResourceResponse;
import com.csidigital.rh.shared.dto.response.TechnicalFileResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor


public class QuestionCategoryImpl implements QuestionCategoryService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private QuestionCategoryRepository questionCategoryRepository;
    @Autowired
    private LevelRespository levelRespository;
    public QuestionCategoryResponse createQuestionCategory(QuestionCategoryRequest request) {
        Level level= levelRespository.findById(request.getLevelId()).orElseThrow();
        QuestionCategory questionCategory = modelMapper.map(request, QuestionCategory.class);
        questionCategory.setLevel(level);
        QuestionCategory questionCategorySaved = questionCategoryRepository.save(questionCategory);
        return modelMapper.map(questionCategorySaved, QuestionCategoryResponse.class);
    }

    @Override
    public List<QuestionCategoryResponse> getAllQuestionCategories() {
        List<QuestionCategory> questionCategories = questionCategoryRepository.findAll();
        List<QuestionCategoryResponse> questionCategoryResponseList = new ArrayList<>();

        for (QuestionCategory questionCategory : questionCategories) {
            QuestionCategoryResponse response = modelMapper.map(questionCategory, QuestionCategoryResponse.class);
            questionCategoryResponseList.add(response);
        }

        return questionCategoryResponseList;
    }

    @Override
    public QuestionCategoryResponse getQuestionCategoryById(Long id) {
        QuestionCategory questionCategory = questionCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("questionCategory with id " + id + " not found"));
        QuestionCategoryResponse  questionCategoryResponse = modelMapper.map(questionCategory, QuestionCategoryResponse.class);
        return questionCategoryResponse;
    }

    @Override
    public QuestionCategoryResponse updateQuestionCategory(QuestionCategoryRequest request, Long id) {
        QuestionCategory existingQuestionCategory = questionCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("QuestionCategory with id: " + id + " not found"));
        modelMapper.map(request, existingQuestionCategory);
        QuestionCategory savedQuestionCategory = questionCategoryRepository.save(existingQuestionCategory);
        return modelMapper.map(savedQuestionCategory, QuestionCategoryResponse .class);    }

    @Override
    public void deleteQuestionCategory(Long id) {questionCategoryRepository.deleteById(id);

    }
}
