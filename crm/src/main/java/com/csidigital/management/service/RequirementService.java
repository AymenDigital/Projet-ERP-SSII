package com.csidigital.management.service;

import com.csidigital.dao.entity.Address;
import com.csidigital.dao.entity.Requirement;
import com.csidigital.shared.dto.request.AddressRequest;
import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.response.RequirementResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface RequirementService {
    RequirementResponse create(RequirementRequest requirementRequest);
    List<RequirementResponse> get();
    RequirementResponse getById(Long id);

    RequirementResponse update(RequirementRequest requirementRequest );

    void delete(Long id);
}
