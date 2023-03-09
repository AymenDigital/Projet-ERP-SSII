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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
public class RequirementServiceImpl implements RequirementService {
    @Autowired
    private RequirementRepository requirementRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RequirementResponse createRequirement(RequirementRequest request) {
        Requirement requirement = modelMapper.map(request, Requirement.class);
        Requirement RequirementSaved = requirementRepository.save(requirement);
        return modelMapper.map(RequirementSaved, RequirementResponse.class);
    }

    @Override
    public List<RequirementResponse> getAllRequirements() {
        List<Requirement> requirements = requirementRepository.findAll();
        List<RequirementResponse> requirementList = new ArrayList<>();

        for (Requirement requirement : requirements) {
            RequirementResponse response = modelMapper.map(requirement, RequirementResponse.class);
            requirementList.add(response);
        }

        return requirementList;
    }

    @Override
    public RequirementResponse getRequirementById(Long id) {
        Requirement requirement = requirementRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Requirement with id " +id+ " not found"));
        RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
        return requirementResponse;
    }

    @Override
    public RequirementResponse updateRequirement(RequirementRequest request, Long id) {
        Requirement existingRequirement = requirementRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Requirement with id: " + id + " not found"));
        modelMapper.map(request, existingRequirement);
        Requirement savedRequirement = requirementRepository.save(existingRequirement);
        return modelMapper.map(savedRequirement, RequirementResponse.class);
    }

    @Override
    public void deleteRequirement(Long id) {
        requirementRepository.deleteById(id);
    }
}
