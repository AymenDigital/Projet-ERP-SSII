package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.Benefit;
import com.csidigital.dao.repository.BenefitRepository;
import com.csidigital.management.service.BenefitService;
import com.csidigital.shared.dto.request.BenefitRequest;
import com.csidigital.shared.dto.response.BenefitResponse;
import com.csidigital.shared.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BenefitServiceImpl implements BenefitService {
    @Autowired
    private BenefitRepository benefitRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BenefitResponse createBenefit(BenefitRequest request) {
        Benefit benefit = modelMapper.map(request, Benefit.class);
        Benefit benefitSaved = benefitRepository.save(benefit);
        return modelMapper.map(benefitSaved, BenefitResponse.class);
    }

    @Override
    public List<BenefitResponse> getAllBenefits() {
        List<Benefit> benefits = benefitRepository.findAll();
        List<BenefitResponse> benefitList = new ArrayList<>();

        for (Benefit benefit : benefits) {
            BenefitResponse response = modelMapper.map(benefit, BenefitResponse.class);
            benefitList.add(response);
        }

        return benefitList;
    }

    @Override
    public BenefitResponse getBenefitById(Long id) {
        Benefit benefit = benefitRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Benefit with id " +id+ " not found"));
        BenefitResponse benefitResponse = modelMapper.map(benefit, BenefitResponse.class);
        return benefitResponse;
    }

    @Override
    public BenefitResponse updateBenefit(BenefitRequest request, Long id) {
        Benefit existingBenefit = benefitRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Benefit with id: " + id + " not found"));
        modelMapper.map(request, existingBenefit);
        Benefit savedBenefit = benefitRepository.save(existingBenefit);
        return modelMapper.map(savedBenefit, BenefitResponse.class);
    }

    @Override
    public void deleteBenefit(Long id) {
        benefitRepository.deleteById(id);
    }
}
