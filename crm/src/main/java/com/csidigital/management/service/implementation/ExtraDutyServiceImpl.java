package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.ExtraDuty;
import com.csidigital.dao.repository.ExtraDutyRepository;
import com.csidigital.management.service.ExtraDutyService;
import com.csidigital.shared.dto.request.ExtraDutyRequest;
import com.csidigital.shared.dto.response.ExtraDutyResponse;
import com.csidigital.shared.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExtraDutyServiceImpl implements ExtraDutyService {
    @Autowired
    private ExtraDutyRepository extraDutyRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ExtraDutyResponse createExtraDuty(ExtraDutyRequest request) {
        ExtraDuty extraDuty = modelMapper.map(request, ExtraDuty.class);
        ExtraDuty extraDutySaved = extraDutyRepository.save(extraDuty);
        return modelMapper.map(extraDutySaved, ExtraDutyResponse.class);
    }

    @Override
    public List<ExtraDutyResponse> getAllExtraDuties() {
        List<ExtraDuty> extraDuties = extraDutyRepository.findAll();
        List<ExtraDutyResponse> extraDutyList = new ArrayList<>();

        for (ExtraDuty extraDuty : extraDuties) {
            ExtraDutyResponse response = modelMapper.map(extraDuty, ExtraDutyResponse.class);
            extraDutyList.add(response);
        }

        return extraDutyList;
    }

    @Override
    public ExtraDutyResponse getExtraDutyById(Long id) {
        ExtraDuty extraDuty = extraDutyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ExtraDuty with id " +id+ " not found"));
        ExtraDutyResponse extraDutyResponse = modelMapper.map(extraDuty, ExtraDutyResponse.class);
        return extraDutyResponse;
    }

    @Override
    public ExtraDutyResponse updateExtraDuty(ExtraDutyRequest request, Long id) {
        ExtraDuty existingExtraDuty = extraDutyRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ExtraDuty with id: " + id + " not found"));
        modelMapper.map(request, existingExtraDuty);
        ExtraDuty savedExtraDuty = extraDutyRepository.save(existingExtraDuty);
        return modelMapper.map(savedExtraDuty, ExtraDutyResponse.class);
    }

    @Override
    public void deleteExtraDuty(Long id) {
        extraDutyRepository.deleteById(id);
    }
}
