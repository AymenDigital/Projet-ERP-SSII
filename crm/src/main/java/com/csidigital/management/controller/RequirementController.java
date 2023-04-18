package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.RequirementServiceImpl;
import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.response.RequirementResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/crm/requirements")
@CrossOrigin("*")
public class RequirementController {
    @Autowired
    private RequirementServiceImpl requirementService ;

    @GetMapping()
    public List<RequirementResponse> getAllRequirements() {
        return requirementService.getAllRequirements();
    }

    @GetMapping("/{id}")
    public RequirementResponse getRequirementById(@PathVariable Long id){
        return requirementService.getRequirementById(id);
    }

    @GetMapping("/{id}/partner")
    public List<RequirementResponse> getRequirementsByPartnerId(@PathVariable Long id){
        return requirementService.getByPartnerId(id);
    }

    @PostMapping()
    public RequirementResponse createRequirement(@Valid @RequestBody RequirementRequest requirementRequest ){
        return requirementService.createRequirement(requirementRequest );
    }

    @PutMapping("/{id}")
    public RequirementResponse updateRequirement(@Valid @RequestBody RequirementRequest requirementRequest,
                                                 @PathVariable Long id){
        return requirementService.updateRequirement(requirementRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRequirement(@PathVariable Long id){
        requirementService.deleteRequirement(id);
    }

}