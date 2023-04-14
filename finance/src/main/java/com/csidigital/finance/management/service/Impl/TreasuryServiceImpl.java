package com.csidigital.finance.management.service.Impl;

import com.csidigital.finance.dao.entity.Treasury;

import com.csidigital.finance.dao.repository.TreasuryRepository;
import com.csidigital.finance.management.service.TreasuryService;
import com.csidigital.finance.shared.dto.Request.TreasuryDtoRequest;
import com.csidigital.finance.shared.dto.Response.TreasuryDtoResponse;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class TreasuryServiceImpl implements TreasuryService {


    @Autowired
    private TreasuryRepository treasuryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TreasuryDtoResponse> getAllTreasury() {
        List<Treasury> treasuries = treasuryRepository.findAll();
        List<TreasuryDtoResponse> treasuryList = new ArrayList<>();

        for (Treasury treasury : treasuries) {
            TreasuryDtoResponse treasuryDtoResponse = modelMapper.map(treasury, TreasuryDtoResponse.class);
            treasuryList.add(treasuryDtoResponse);
        }

        return treasuryList;    }

    @Override
    public TreasuryDtoResponse getTreasuryById(Long id) {
        Treasury treasury = treasuryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Treasury with id " +id+ " not found"));
        TreasuryDtoResponse treasuryDtoResponse = modelMapper.map(treasury, TreasuryDtoResponse.class);
        return treasuryDtoResponse;    }

    @Override
    public TreasuryDtoResponse CreateTreasury(TreasuryDtoRequest treasuryDtoRequest) {
        Treasury treasury = modelMapper.map(treasuryDtoRequest, Treasury.class);
        Treasury TreasurySaved = treasuryRepository.save(treasury);
        return modelMapper.map(TreasurySaved, TreasuryDtoResponse.class);
    }

    @Override
    public TreasuryDtoResponse updateTreasury(TreasuryDtoRequest treasuryDtoRequest, Long id) {
        Treasury treasury = treasuryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Treasury with id: " + id + " not found"));
        modelMapper.map(treasuryDtoRequest, treasury);
        Treasury updatedTreasury = treasuryRepository.save(treasury);
        return modelMapper.map(updatedTreasury, TreasuryDtoResponse.class);    }

    @Override
    public void deleteTreasuryById(Long id) {
        treasuryRepository.deleteById(id);

    }

}
