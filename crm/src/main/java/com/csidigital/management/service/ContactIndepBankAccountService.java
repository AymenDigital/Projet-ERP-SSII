package com.csidigital.management.service;

import com.csidigital.shared.dto.request.ContactIndepBankAccountRequest;
import com.csidigital.shared.dto.request.OrderRequest;
import com.csidigital.shared.dto.response.ContactIndepBankAccountResponse;

import java.util.List;

public interface ContactIndepBankAccountService {
    ContactIndepBankAccountResponse createBankAccount(ContactIndepBankAccountRequest request);

    List<ContactIndepBankAccountResponse> getAllBankAccounts();
    ContactIndepBankAccountResponse getBankAccountById(Long id);

    ContactIndepBankAccountResponse updateBankAccount(ContactIndepBankAccountRequest request, Long id);

    void deleteBankAccount(Long id);
}
