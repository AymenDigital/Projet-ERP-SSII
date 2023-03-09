package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.RequirementServiceImpl;
import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.response.RequirementResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/requirement")
public class RequirementController {
    @Autowired
    private RequirementServiceImpl requirementService ;
    @GetMapping()
    public List<RequirementResponse> Get() {
        return requirementService.get();
    }

    @GetMapping("/{id}")
    public RequirementResponse getById(@PathVariable Long id){
        return requirementService.getById(id);
    }

    @PostMapping()
    public RequirementResponse createRequirement(@Valid @RequestBody RequirementRequest requirementRequest){
        return requirementService.create(requirementRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteRequirement(@PathVariable Long id){
        requirementService.delete(id);
    }
}
