package com.csidigital.finance.management.service.Impl;

import com.csidigital.finance.dao.entity.BankReconciliation;
import com.csidigital.finance.dao.entity.Treasury;
import com.csidigital.finance.dao.repository.BankReconciliationRepository;
import com.csidigital.finance.dao.repository.TreasuryRepository;
import com.csidigital.finance.management.service.BankReconciliationService;
import com.csidigital.finance.shared.dto.Request.BankReconciliationDtoRequest;
import com.csidigital.finance.shared.dto.Response.BankReconciliationDtoResponse;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BankReconciliationServiceImpl implements BankReconciliationService {

    @Autowired
    private BankReconciliationRepository bankReconciliationRepository;
    @Autowired
    private TreasuryRepository treasuryRepository ;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<BankReconciliationDtoResponse> getAllBankReconciliation() {
        List<BankReconciliation> bankReconciliations = bankReconciliationRepository.findAll();
        List<BankReconciliationDtoResponse> bankReconciliationList = new ArrayList<>();

        for (BankReconciliation bankReconciliation : bankReconciliations) {
            BankReconciliationDtoResponse bankReconciliationDtoResponse = modelMapper.map(bankReconciliation, BankReconciliationDtoResponse.class);
            bankReconciliationList.add(bankReconciliationDtoResponse);
        }

        return bankReconciliationList;      }

    @Override
    public BankReconciliationDtoResponse getBankReconciliationById(Long id) {
        BankReconciliation bankReconciliation = bankReconciliationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("BankReconciliation with id " +id+ " not found"));
        BankReconciliationDtoResponse bankReconciliationDtoResponse = modelMapper.map(bankReconciliation, BankReconciliationDtoResponse.class);
        return bankReconciliationDtoResponse;
    }

    @Override
    public BankReconciliationDtoResponse CreateBankReconciliation(BankReconciliationDtoRequest bankReconciliationDtoRequest) {
        BankReconciliation bankReconciliation = modelMapper.map(bankReconciliationDtoRequest, BankReconciliation.class);
        Treasury treasury = treasuryRepository.findById(bankReconciliationDtoRequest.getTreasuryId()).orElseThrow();
        bankReconciliation.setTreasury(treasury);
        BankReconciliation bankReconciliationSaved = bankReconciliationRepository.save(bankReconciliation);
        return modelMapper.map(bankReconciliationSaved, BankReconciliationDtoResponse.class);    }

    @Override
    public BankReconciliationDtoResponse updateBankReconciliation(BankReconciliationDtoRequest bankReconciliationDtoRequest, Long id) {
        BankReconciliation bankReconciliation = bankReconciliationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("BankReconciliation with id: " + id + " not found"));
        modelMapper.map(bankReconciliationDtoRequest, bankReconciliation);
        BankReconciliation updatedBankReconciliation = bankReconciliationRepository.save(bankReconciliation);
        return modelMapper.map(updatedBankReconciliation, BankReconciliationDtoResponse.class);      }

    @Override
    public void deleteBankReconciliationById(Long id) {
        bankReconciliationRepository.deleteById(id);
    }
}
