package com.csidigital.finance.management.service.Impl;

import com.csidigital.finance.dao.entity.AdditionalFee;
import com.csidigital.finance.dao.entity.Bill;
import com.csidigital.finance.dao.repository.AdditionalFeeRepository;
import com.csidigital.finance.dao.repository.BillRepository;
import com.csidigital.finance.management.service.AdditionalFeeService;
import com.csidigital.finance.shared.dto.Request.AdditionalFeeDtoRequest;
import com.csidigital.finance.shared.dto.Response.AdditionalFeeDtoResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
public class AdditionalFeeServiceImpl implements AdditionalFeeService {

    @Autowired
    private AdditionalFeeRepository additionalFeeRepository;
    @Autowired
    private BillRepository billRepository ;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AdditionalFeeDtoResponse<Number>> getAllAdditionalFee() {
        List<AdditionalFee> additionalFees = additionalFeeRepository.findAll();
        List<AdditionalFeeDtoResponse<Number>> additionalFeeList = new ArrayList<>();

        for (AdditionalFee additionalFee : additionalFees) {
            AdditionalFeeDtoResponse<Number> additionalFeeDtoResponse = modelMapper.map(additionalFee, AdditionalFeeDtoResponse.class);
            additionalFeeList.add(additionalFeeDtoResponse);
        }

        return additionalFeeList;
    }

    @Override
    public AdditionalFeeDtoResponse<Number> getAdditionalFeeById(Long id) {
        AdditionalFee additionalFee = additionalFeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("AdditionalFee with id " +id+ " not found"));
        AdditionalFeeDtoResponse<Number> additionalFeeDtoResponse = modelMapper.map(additionalFee, AdditionalFeeDtoResponse.class);
        return additionalFeeDtoResponse;    }

    @Override
    public List<AdditionalFeeDtoResponse<Number>> CreateAdditionalFee(List<AdditionalFeeDtoRequest> additionalFeeDtoRequests) {
        List<AdditionalFeeDtoResponse<Number>> additionalFeeDtoResponses = new ArrayList<>();
        for (AdditionalFeeDtoRequest additionalFeeDtoRequest : additionalFeeDtoRequests) {
            Bill bill = billRepository.findById(additionalFeeDtoRequest.getBillId()).orElseThrow();
            AdditionalFee additionalFee = modelMapper.map(additionalFeeDtoRequest, AdditionalFee.class);
            additionalFee.setBill(bill);
            AdditionalFee AdditionalFeeSaved = additionalFeeRepository.save(additionalFee);
            additionalFeeDtoResponses.add(modelMapper.map(AdditionalFeeSaved, AdditionalFeeDtoResponse.class));
        }

        return additionalFeeDtoResponses;
    }





    @Override
    public AdditionalFeeDtoResponse<Number> updateAdditionalFee(@Valid AdditionalFeeDtoRequest additionalFeeDtoRequest, Long id) {
        AdditionalFee additionalFee = additionalFeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("AdditionalFee with id: " + id + " not found"));
        modelMapper.map(additionalFeeDtoRequest, additionalFee);
        AdditionalFee updatedAdditionalFee = additionalFeeRepository.save(additionalFee);
        return modelMapper.map(updatedAdditionalFee, AdditionalFeeDtoResponse.class);    }

    @Override
    public void deleteAdditionalFeeById(Long id) {
        additionalFeeRepository.deleteById(id);

    }


}
