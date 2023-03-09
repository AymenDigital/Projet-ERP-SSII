package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.RequirementServiceImpl;
import com.csidigital.shared.dto.response.RequirementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("requirement")
public class RequirementController {
    @Autowired
private RequirementServiceImpl requirementService ;
    @GetMapping()
    public List<RequirementResponse> Get() {
        return requirementService.get();
    }

}
