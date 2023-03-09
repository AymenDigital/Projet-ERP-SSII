package com.csidigital.management.service;

import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.request.WorkArrangementRequest;
import com.csidigital.shared.dto.response.RequirementResponse;
import com.csidigital.shared.dto.response.WorkArrangementResponse;

import java.util.List;

public interface WorkArrangementService {
    WorkArrangementResponse create(WorkArrangementRequest workArrangementRequest);
    List<WorkArrangementResponse> get();
    WorkArrangementResponse getById(Long id);

    WorkArrangementResponse update(WorkArrangementRequest workArrangementRequest );

    void delete(Long id);
}
