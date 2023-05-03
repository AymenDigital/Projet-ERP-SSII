package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.Partner;
import com.csidigital.dao.entity.PartnerBankAccount;
import com.csidigital.dao.repository.PartnerBankAccountRepository;
import com.csidigital.dao.repository.PartnerRepository;
import com.csidigital.management.service.PartnerBankAccountService;
import com.csidigital.shared.dto.request.PartnerBankAccountRequest;
import com.csidigital.shared.dto.response.PartnerBankAccountResponse;
import com.csidigital.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class PartnerBankAccountServiceImpl implements PartnerBankAccountService {
    @Autowired
    private PartnerBankAccountRepository bankAccountRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PartnerRepository repository;
    @Override
    public PartnerBankAccountResponse createBankAccount(PartnerBankAccountRequest request) {
        Partner partner = repository.findById(request.getPartnerNum())
                .orElseThrow(()-> new ResourceNotFoundException("Independent Contact with id " +request.getPartnerNum()+ " not found"));
        PartnerBankAccount bankAccount = modelMapper.map(request, PartnerBankAccount.class);
        bankAccount.setPartner(partner);
        PartnerBankAccount bankAccountSaved = bankAccountRepository.save(bankAccount);
        return modelMapper.map(bankAccountSaved, PartnerBankAccountResponse.class);
    }

    @Override
    public List<PartnerBankAccountResponse> getAllBankAccounts() {
        List<PartnerBankAccount> bankAccounts = bankAccountRepository.findAll();
        List<PartnerBankAccountResponse> bankAccountResponseList = new ArrayList<>();

        for (PartnerBankAccount bankAccount : bankAccounts) {
            PartnerBankAccountResponse response = modelMapper.map(bankAccount, PartnerBankAccountResponse.class);
            bankAccountResponseList.add(response);
        }
        return bankAccountResponseList;
    }

    @Override
    public PartnerBankAccountResponse getBankAccountById(Long id) {
        PartnerBankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Bank account with id " +id+ " not found"));
        PartnerBankAccountResponse response = modelMapper.map(bankAccount, PartnerBankAccountResponse.class);
        return response;
    }

    @Override
    public PartnerBankAccountResponse updateBankAccount(PartnerBankAccountRequest request, Long id) {
        PartnerBankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Bank account with id: " + id + " not found"));
        modelMapper.map(request, bankAccount);
        PartnerBankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return modelMapper.map(savedBankAccount, PartnerBankAccountResponse.class);
    }

    @Override
    public void deleteBankAccount(Long id) {
        bankAccountRepository.deleteById(id);
    }
}
