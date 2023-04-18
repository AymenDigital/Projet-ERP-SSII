package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.ContactPartner;
import com.csidigital.dao.entity.Partner;
import com.csidigital.dao.entity.Requirement;
import com.csidigital.dao.repository.PartnerRepository;
import com.csidigital.dao.repository.RequirementRepository;
import com.csidigital.management.service.RequirementService;
import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.response.PartnerContactResponse;
import com.csidigital.shared.dto.response.RequirementResponse;
import com.csidigital.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class RequirementServiceImpl implements RequirementService {
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private RequirementRepository requirementRepository ;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RequirementResponse createRequirement(RequirementRequest request) {
        Partner partner = partnerRepository.findById(request.getPartnerNum())
                .orElseThrow(() -> new ResourceNotFoundException("Partner not found"));
        Requirement requirement = modelMapper.map(request, Requirement.class);
        requirement.setPartner(partner);
        Requirement savedRequirement = requirementRepository.save(requirement);
        return modelMapper.map(savedRequirement, RequirementResponse.class);

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
    public List<RequirementResponse> getByPartnerId(Long id) {
        List<Requirement> partnerRequirementList = requirementRepository.findByPartnerId(id);
        List<RequirementResponse> requirementList = new ArrayList<>();
        for (Requirement requirement : partnerRequirementList) {
            RequirementResponse response = modelMapper.map(requirement, RequirementResponse.class);
            requirementList.add(response);
        }
        return requirementList;
    }

    @Override
    public RequirementResponse updateRequirement(RequirementRequest request, Long id) {
        Partner partner = partnerRepository.findById(request.getPartnerNum())
                .orElseThrow(() -> new ResourceNotFoundException("Partner not found"));
        Requirement existingRequirement = requirementRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Requirement with id: " + id + " not found"));

        modelMapper.map(request, existingRequirement);
        existingRequirement.setPartner(partner);
        Requirement savedRequirement = requirementRepository.save(existingRequirement);
        return modelMapper.map(savedRequirement, RequirementResponse.class);
    }

    @Override
    public void deleteRequirement(Long id) {
        requirementRepository.deleteById(id);
    }
}
