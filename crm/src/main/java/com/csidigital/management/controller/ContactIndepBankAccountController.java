package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.ContactIndepBankAccountServiceImpl;
import com.csidigital.shared.dto.request.ContactIndepBankAccountRequest;
import com.csidigital.shared.dto.response.ContactIndepBankAccountResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crm/contactBankAccounts")
@CrossOrigin(origins = "${cross.origin.url}")
public class ContactIndepBankAccountController {
    @Autowired
    private ContactIndepBankAccountServiceImpl accountService ;

    @GetMapping()
    public List<ContactIndepBankAccountResponse> getAllBankAccounts() {
        return accountService.getAllBankAccounts();
    }

    @GetMapping("/{id}")
    public ContactIndepBankAccountResponse getBankAccountById(@PathVariable Long id){
        return accountService.getBankAccountById(id);
    }

    @PostMapping()
    public ContactIndepBankAccountResponse createBankAccount(@Valid @RequestBody ContactIndepBankAccountRequest request){
        return accountService.createBankAccount(request);
    }

    @PutMapping("/{id}")
    public ContactIndepBankAccountResponse updateBankAccount(@Valid @RequestBody ContactIndepBankAccountRequest request,
                                                        @PathVariable Long id){
        return accountService.updateBankAccount(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable Long id){
        accountService.deleteBankAccount(id);
    }

}
