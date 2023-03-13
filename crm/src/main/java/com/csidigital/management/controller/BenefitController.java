package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.BenefitServiceImpl;
import com.csidigital.shared.dto.request.BenefitRequest;
import com.csidigital.shared.dto.response.BenefitResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crm/benefits")
@CrossOrigin("*")
public class BenefitController {
    @Autowired
    private BenefitServiceImpl benefitService ;

    @GetMapping()
    public List<BenefitResponse> getAllBenefits() {
        return benefitService.getAllBenefits();
    }

    @GetMapping("/{id}")
    public BenefitResponse getBenefitById(@PathVariable Long id){
        return benefitService.getBenefitById(id);
    }

    @PostMapping()
    public BenefitResponse createBenefit(@Valid @RequestBody BenefitRequest benefitRequest){
        return benefitService.createBenefit(benefitRequest);
    }

    @PutMapping("/{id}")
    public BenefitResponse updateBenefit(@Valid @RequestBody BenefitRequest benefitRequest,
                                                 @PathVariable Long id){
        return benefitService.updateBenefit(benefitRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBenefit(@PathVariable Long id){
        benefitService.deleteBenefit(id);
    }

}
