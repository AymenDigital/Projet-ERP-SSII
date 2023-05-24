package com.csidigital.finance.management.service.Impl;

import com.csidigital.finance.dao.entity.BillClient;
import com.csidigital.finance.dao.entity.FeeClient;
import com.csidigital.finance.dao.repository.BillClientRepository;
import com.csidigital.finance.dao.repository.FeeClientRepository;
import com.csidigital.finance.management.service.FeeClientService;
import com.csidigital.finance.shared.dto.Request.FeeClientDtoRequest;
import com.csidigital.finance.shared.dto.Response.FeeClientDtoResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FeeClientServiceImpl implements FeeClientService {

    @Autowired
    private FeeClientRepository feeClientRepository;

    @Autowired
    private BillClientRepository billClientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FeeClientDtoResponse<Number>> getAllFeeClient() {
        List<FeeClient> feeClients = feeClientRepository.findAll();
        List<FeeClientDtoResponse<Number>> feeClientList = new ArrayList<>();

        for (FeeClient feeClient : feeClients) {
            FeeClientDtoResponse<Number> feeClientDtoResponse = modelMapper.map(feeClient, FeeClientDtoResponse.class);
            feeClientList.add(feeClientDtoResponse);
        }

        return feeClientList;
    }

    @Override
    public FeeClientDtoResponse<Number> getFeeClientById(Long id) {
        FeeClient feeClient = feeClientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FeeClient with id " + id + " not found"));
        FeeClientDtoResponse<Number> feeClientDtoResponse = modelMapper.map(feeClient, FeeClientDtoResponse.class);
        return feeClientDtoResponse;
    }

    @Override
    public List<FeeClientDtoResponse<Number>> CreateFeeClient(List<FeeClientDtoRequest> feeClientDtoRequests) {
        List<FeeClientDtoResponse<Number>> feeClientDtoResponses = new ArrayList<>();
        for (FeeClientDtoRequest feeClientDtoRequest : feeClientDtoRequests) {
            BillClient billClient = billClientRepository.findById(feeClientDtoRequest.getBillClientId()).orElseThrow();
            FeeClient feeClient = modelMapper.map(feeClientDtoRequest, FeeClient.class);
            feeClient.setBillClient(billClient);
            FeeClient FeeClientSaved = feeClientRepository.save(feeClient);
            feeClientDtoResponses.add(modelMapper.map(FeeClientSaved, FeeClientDtoResponse.class));
        }

        return feeClientDtoResponses;
    }

    @Override
    public FeeClientDtoResponse<Number> updateFeeClient(@Valid FeeClientDtoRequest feeClientDtoRequest, Long id) {
        FeeClient feeClient = feeClientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FeeClient with id: " + id + " not found"));
        modelMapper.map(feeClientDtoRequest, feeClient);
        FeeClient updatedFeeClient = feeClientRepository.save(feeClient);
        return modelMapper.map(updatedFeeClient, FeeClientDtoResponse.class);
    }

    @Override
    public void deleteFeeClientById(Long id) {
        feeClientRepository.deleteById(id);
    }
}
