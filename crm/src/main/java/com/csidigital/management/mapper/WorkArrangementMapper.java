package com.csidigital.management.mapper;

import com.csidigital.dao.entity.Requirement;
import com.csidigital.dao.entity.WorkArrangement;
import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.request.WorkArrangementRequest;
import com.csidigital.shared.dto.response.RequirementResponse;
import com.csidigital.shared.dto.response.WorkArrangementResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class WorkArrangementMapper {
    public WorkArrangementResponse toWorkArrangementResponseDto(WorkArrangement workArrangement) {
        WorkArrangementResponse workArrangementResponse = new WorkArrangementResponse();
        BeanUtils.copyProperties(workArrangement, workArrangementResponse);
        return workArrangementResponse;
    }

    public WorkArrangement toWorkArrangement(WorkArrangementRequest workArrangementRequest) {
        WorkArrangement workArrangement = new WorkArrangement();
        BeanUtils.copyProperties(workArrangementRequest, workArrangement);
        return workArrangement;
    }
}