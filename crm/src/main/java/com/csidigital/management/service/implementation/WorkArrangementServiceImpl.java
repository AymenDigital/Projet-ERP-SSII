package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.WorkArrangement;


import com.csidigital.dao.repository.WorkArrangementRepository;

import com.csidigital.management.mapper.WorkArrangementMapper;
import com.csidigital.management.service.WorkArrangementService;
import com.csidigital.shared.dto.request.WorkArrangementRequest;

import com.csidigital.shared.dto.response.WorkArrangementResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class WorkArrangementServiceImpl implements WorkArrangementService {
    private WorkArrangementMapper workArrangementMapper;
    private WorkArrangementRepository workArrangementRepository ;
    @Override
    public WorkArrangementResponse create(WorkArrangementRequest workArrangementRequest) {
       WorkArrangement workArrangement= workArrangementMapper.toWorkArrangement(workArrangementRequest);
        WorkArrangement savedworkArrangement = workArrangementRepository.save(workArrangement);
        WorkArrangementResponse workArrangementResponse = workArrangementMapper.toWorkArrangementResponseDto(savedworkArrangement);
        return workArrangementResponse ;
    }

    @Override
    public List<WorkArrangementResponse> get() {
        return null;
    }

    @Override
    public WorkArrangementResponse getById(Long id) {
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
