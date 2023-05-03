package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.ContactIndep;
import com.csidigital.dao.entity.ContactIndepBankAccount;
import com.csidigital.dao.repository.ContactIndepBankAccountRepository;
import com.csidigital.dao.repository.ContactIndepRepository;
import com.csidigital.management.service.ContactIndepBankAccountService;
import com.csidigital.shared.dto.request.ContactIndepBankAccountRequest;
import com.csidigital.shared.dto.response.ContactIndepBankAccountResponse;
import com.csidigital.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class ContactIndepBankAccountServiceImpl implements ContactIndepBankAccountService {
    @Autowired
    private ContactIndepBankAccountRepository bankAccountRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ContactIndepRepository repository;
    @Override
    public ContactIndepBankAccountResponse createBankAccount(ContactIndepBankAccountRequest request) {
        ContactIndep contactIndep = repository.findById(request.getContactIndepNum())
                .orElseThrow(()-> new ResourceNotFoundException("Independent Contact with id " +request.getContactIndepNum()+ " not found"));
        ContactIndepBankAccount bankAccount = modelMapper.map(request, ContactIndepBankAccount.class);
        bankAccount.setContactIndep(contactIndep);
        ContactIndepBankAccount bankAccountSaved = bankAccountRepository.save(bankAccount);
        return modelMapper.map(bankAccountSaved, ContactIndepBankAccountResponse.class);
    }

    @Override
    public List<ContactIndepBankAccountResponse> getAllBankAccounts() {
        List<ContactIndepBankAccount> bankAccounts = bankAccountRepository.findAll();
        List<ContactIndepBankAccountResponse> bankAccountResponseList = new ArrayList<>();

        for (ContactIndepBankAccount bankAccount : bankAccounts) {
            ContactIndepBankAccountResponse response = modelMapper.map(bankAccount, ContactIndepBankAccountResponse.class);
            bankAccountResponseList.add(response);
        }
        return bankAccountResponseList;
    }

    @Override
    public ContactIndepBankAccountResponse getBankAccountById(Long id) {
        ContactIndepBankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Bank account with id " +id+ " not found"));
        ContactIndepBankAccountResponse response = modelMapper.map(bankAccount, ContactIndepBankAccountResponse.class);
        return response;
    }

    @Override
    public ContactIndepBankAccountResponse updateBankAccount(ContactIndepBankAccountRequest request, Long id) {
        ContactIndepBankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Bank account with id: " + id + " not found"));
        modelMapper.map(request, bankAccount);
        ContactIndepBankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return modelMapper.map(savedBankAccount, ContactIndepBankAccountResponse.class);
    }

    @Override
    public void deleteBankAccount(Long id) {
        bankAccountRepository.deleteById(id);
    }
}
