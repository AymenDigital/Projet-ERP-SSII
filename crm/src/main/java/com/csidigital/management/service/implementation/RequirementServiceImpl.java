package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.Requirement;
import com.csidigital.dao.repository.RequirementRepository;
import com.csidigital.management.mapper.RequirementMapper;
import com.csidigital.management.service.RequirementService;
import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.response.RequirementResponse;
import com.csidigital.shared.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
public class RequirementServiceImpl implements RequirementService {

    private RequirementMapper requirementMapper ;
    private RequirementRepository requirementRepository ;
    @Override
    public RequirementResponse create(RequirementRequest requirementRequest) {
        Requirement requirement= requirementMapper.toRequirement(requirementRequest);
        Requirement savedRequirement = requirementRepository.save(requirement);
        RequirementResponse requirementResponse = requirementMapper.toRequirementResponseDto(savedRequirement);
        return requirementResponse ;
    }

    @Override
    public List<RequirementResponse> get() {
        List<Requirement> requirements = requirementRepository.findAll();
        List<RequirementResponse> requirementResponse = requirements
                .stream().map(requirementMapper::toRequirementResponseDto).collect(Collectors.toList());
        return requirementResponse ;
    }

    @Override
    public RequirementResponse getById(Long id) {
        Requirement requirement = requirementRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Requirement with id " +id+ " not found"));
        RequirementResponse requirementResponse = requirementMapper.toRequirementResponseDto(requirement);
        return requirementResponse ;

    }

    @Override
    public RequirementResponse update(RequirementRequest request) {
        Requirement requirement = requirementMapper.toRequirement(request);
       Requirement savedRequirement = requirementRepository.save(requirement);
       return  requirementMapper.toRequirementResponseDto(savedRequirement);
      /*  requirement.setTitle(request.getTitle());
        requirement.setDescription(request.getDescription());
        requirement.setRequirementType(request.getRequirementType());
        requirement.setCriteria(request.getCriteria());
        requirement.setRequirementStatus(request.getRequirementStatus());
        requirement.setWorkField(request.getWorkField());
        requirement.setAvailability(request.getAvailability());
        requirement.setPlannedBudget(request.getPlannedBudget());*/


    }

    @Override
    public void delete(Long id) {
        requirementRepository.deleteById(id);


    }
}
