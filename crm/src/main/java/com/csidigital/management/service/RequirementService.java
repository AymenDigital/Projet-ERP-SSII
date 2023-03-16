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
    RequirementResponse createRequirement(RequirementRequest request );
    List<RequirementResponse> getAllRequirements();
    RequirementResponse getRequirementById(Long id);

    RequirementResponse updateRequirement(RequirementRequest request, Long id);

    void deleteRequirement(Long id);
}
