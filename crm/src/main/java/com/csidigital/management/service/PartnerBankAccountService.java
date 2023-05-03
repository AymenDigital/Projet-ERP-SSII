package com.csidigital.management.service;

import com.csidigital.shared.dto.request.OrderRequest;
import com.csidigital.shared.dto.request.PartnerBankAccountRequest;
import com.csidigital.shared.dto.response.OrderResponse;
import com.csidigital.shared.dto.response.PartnerBankAccountResponse;
import com.csidigital.shared.dto.response.PartnerResponse;

import java.util.List;

public interface PartnerBankAccountService {
    PartnerBankAccountResponse createBankAccount(PartnerBankAccountRequest request);
    List<PartnerBankAccountResponse> getAllBankAccounts();
    PartnerBankAccountResponse getBankAccountById(Long id);

    PartnerBankAccountResponse updateBankAccount(PartnerBankAccountRequest request , Long id );

    void deleteBankAccount(Long id);
}
