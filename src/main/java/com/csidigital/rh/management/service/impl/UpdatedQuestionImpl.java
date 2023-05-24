package com.csidigital.rh.management.service.impl;


import com.csidigital.rh.dao.entity.UpdatedQuestion;
import com.csidigital.rh.dao.repository.UpdatedQuestionRepository;
import com.csidigital.rh.management.service.UpdatedQuestionService;
import com.csidigital.rh.shared.dto.request.UpdatedQuestionRequest;
import com.csidigital.rh.shared.dto.response.UpdatedQuestionResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UpdatedQuestionImpl implements UpdatedQuestionService {

    @Autowired
    private UpdatedQuestionRepository updatedQuestionRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UpdatedQuestionResponse createUpdatedQuestion(UpdatedQuestionRequest request) {
        UpdatedQuestion updatedQuestion = modelMapper.map(request,  UpdatedQuestion.class);
        UpdatedQuestion  UpdatedQuestionSaved =  updatedQuestionRepository.save(updatedQuestion);
        return modelMapper.map( UpdatedQuestionSaved,  UpdatedQuestionResponse.class);
    }

    @Override
    public List< UpdatedQuestionResponse> getAllUpdatedQuestion() {
        List< UpdatedQuestion> updatedQuestion =  updatedQuestionRepository.findAll();
        List< UpdatedQuestionResponse> updatedQuestionList = new ArrayList<>();


        for ( UpdatedQuestion updatedQuestion1:  updatedQuestion) {
            UpdatedQuestionResponse response = modelMapper.map( updatedQuestion1,  UpdatedQuestionResponse.class);
            updatedQuestionList.add(response);
        }

        return updatedQuestionList;
    }

    @Override
    public  UpdatedQuestionResponse getUpdatedQuestionById(Long id) {
        UpdatedQuestion updatedQuestion = updatedQuestionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(" UpdatedQuestion with id " +id+ " not found"));
        UpdatedQuestionResponse updatedQuestionResponse = modelMapper.map( updatedQuestion,  UpdatedQuestionResponse.class);
        return  updatedQuestionResponse;
    }

    @Override
    public  UpdatedQuestionResponse updateUpdatedQuestion( UpdatedQuestionRequest request, Long id) {
        UpdatedQuestion existingUpdatedQuestion =  updatedQuestionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(" UpdatedQuestion with id: " + id + " not found"));
        modelMapper.map(request, existingUpdatedQuestion);
        UpdatedQuestion savedUpdatedQuestion =  updatedQuestionRepository.save(existingUpdatedQuestion);
        return modelMapper.map(savedUpdatedQuestion,  UpdatedQuestionResponse.class);
    }

    @Override
    public void deleteUpdatedQuestion(Long id) {
        updatedQuestionRepository.deleteById(id);
    }
}
