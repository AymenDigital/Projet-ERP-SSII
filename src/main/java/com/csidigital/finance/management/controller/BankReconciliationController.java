package com.csidigital.finance.management.controller;

import com.csidigital.finance.management.service.BankReconciliationService;
import com.csidigital.finance.shared.dto.Request.BankReconciliationDtoRequest;
import com.csidigital.finance.shared.dto.Response.BankReconciliationDtoResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fm/bankReconciliation")
@CrossOrigin("*")
public class BankReconciliationController {
    private final BankReconciliationService bankReconciliationService ;

    public BankReconciliationController(BankReconciliationService bankReconciliationService) {
        this.bankReconciliationService = bankReconciliationService;
    }

    @GetMapping()
    public List<BankReconciliationDtoResponse> getAllBankReconciliation() {
        return bankReconciliationService.getAllBankReconciliation();
    }

    @GetMapping("/{id}")
    public BankReconciliationDtoResponse getBankReconciliationById(@PathVariable Long id){
        return bankReconciliationService.getBankReconciliationById(id);
    }

    @PostMapping()
    public BankReconciliationDtoResponse createBankReconciliation(@Valid @RequestBody BankReconciliationDtoRequest bankReconciliationDtoRequest){
        return bankReconciliationService.CreateBankReconciliation(bankReconciliationDtoRequest);
    }

    @PutMapping("/{id}")
    public BankReconciliationDtoResponse updateBankReconciliation(@Valid @RequestBody BankReconciliationDtoRequest bankReconciliationDtoRequest, @PathVariable Long id){
        return bankReconciliationService.updateBankReconciliation(bankReconciliationDtoRequest, id);
    }


    @DeleteMapping("/{id}")
    public void deleteBankReconciliation(@PathVariable Long id){
        bankReconciliationService.deleteBankReconciliationById(id);
    }
}
