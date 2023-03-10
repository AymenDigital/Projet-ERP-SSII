package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.Requirement;
import com.csidigital.dao.entity.WorkArrangement;


import com.csidigital.dao.repository.WorkArrangementRepository;

import com.csidigital.management.mapper.WorkArrangementMapper;
import com.csidigital.management.service.WorkArrangementService;
import com.csidigital.shared.dto.request.WorkArrangementRequest;

import com.csidigital.shared.dto.response.RequirementResponse;
import com.csidigital.shared.dto.response.WorkArrangementResponse;
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
public class WorkArrangementServiceImpl implements WorkArrangementService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private WorkArrangementRepository workArrangementRepository ;
    @Override
    public WorkArrangementResponse createWorkArrangement(WorkArrangementRequest Request) {
       WorkArrangement workArrangement= modelMapper.map(Request , WorkArrangement.class);
        WorkArrangement savedworkArrangement = workArrangementRepository.save(workArrangement);
       return modelMapper.map(savedworkArrangement , WorkArrangementResponse.class);

    }

    @Override
    public List<WorkArrangementResponse> getAllWorkArrangements() {
        List<WorkArrangement> workArrangements = workArrangementRepository.findAll();
        List<WorkArrangementResponse> workArrangementList = new ArrayList<>();
        for (WorkArrangement workArrangement: workArrangements) {
            WorkArrangementResponse response = modelMapper.map(workArrangement, WorkArrangementResponse.class);
            workArrangementList.add(response);
        }
            return  workArrangementList ;


    }

    @Override
    public WorkArrangementResponse getWorkArrangementById(Long id) {
        return null;
    }

    @Override
    public WorkArrangementResponse update(WorkArrangementRequest workArrangementRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
