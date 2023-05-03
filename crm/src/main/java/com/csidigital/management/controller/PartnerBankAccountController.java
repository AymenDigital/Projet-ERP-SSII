package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.PartnerBankAccountServiceImpl;
import com.csidigital.shared.dto.request.ContactIndepRequest;
import com.csidigital.shared.dto.request.PartnerBankAccountRequest;
import com.csidigital.shared.dto.response.ContactIndepResponse;
import com.csidigital.shared.dto.response.PartnerBankAccountResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crm/partnerBankAccounts")
@CrossOrigin(origins = "${cross.origin.url}")
public class PartnerBankAccountController {
    @Autowired
    private PartnerBankAccountServiceImpl accountService ;

    @GetMapping()
    public List<PartnerBankAccountResponse> getAllBankAccounts() {
        return accountService.getAllBankAccounts();
    }

    @GetMapping("/{id}")
    public PartnerBankAccountResponse getBankAccountById(@PathVariable Long id){
        return accountService.getBankAccountById(id);
    }

    @PostMapping()
    public PartnerBankAccountResponse createBankAccount(@Valid @RequestBody PartnerBankAccountRequest request){
        return accountService.createBankAccount(request);
    }

    @PutMapping("/{id}")
    public PartnerBankAccountResponse updateBankAccount(@Valid @RequestBody PartnerBankAccountRequest request,
                                                   @PathVariable Long id){
        return accountService.updateBankAccount(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable Long id){
        accountService.deleteBankAccount(id);
    }
}
