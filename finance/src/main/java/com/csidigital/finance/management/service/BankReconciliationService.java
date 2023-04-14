package com.csidigital.finance.management.service;

import com.csidigital.finance.shared.dto.Request.BankReconciliationDtoRequest;
import com.csidigital.finance.shared.dto.Response.BankReconciliationDtoResponse;

import java.util.List;

public interface BankReconciliationService {
    //Get All BankReconciliation

    List<BankReconciliationDtoResponse> getAllBankReconciliation();

    //Get BankReconciliation by id

    BankReconciliationDtoResponse getBankReconciliationById(Long id);

    //Add new BankReconciliation

    BankReconciliationDtoResponse CreateBankReconciliation(BankReconciliationDtoRequest checkDtoRequest);

    //Update BankReconciliation by id
    BankReconciliationDtoResponse updateBankReconciliation(BankReconciliationDtoRequest checkDtoRequest, Long id);

    //delete BankReconciliation by id
    void deleteBankReconciliationById(Long id);

}
