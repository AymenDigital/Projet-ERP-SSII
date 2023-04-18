package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.ContactPServiceImpl;
import com.csidigital.shared.dto.request.ContactPRequest;
import com.csidigital.shared.dto.response.PartnerContactResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crm/partnerContacts")
@CrossOrigin("*")
public class ContactPartnerController {
    @Autowired
    private ContactPServiceImpl partnerContactService;
    @GetMapping()
    public List<PartnerContactResponse> getAllPartnerContacts() {
        return partnerContactService.getAllPartnerContacts();
    }

    @GetMapping("/{id}")
    public PartnerContactResponse getPartnerContactById(@PathVariable Long id){
        return partnerContactService.getPartnerContactById(id);
    }

    @GetMapping("/{id}/partner")
    public List<PartnerContactResponse> getContactsByPartnerId(@PathVariable Long id){
        return partnerContactService.getByPartnerId(id);
    }

    @PostMapping()
    public PartnerContactResponse createPartnerContact(@Valid @RequestBody ContactPRequest request){
        return partnerContactService.createPartnerContact(request);
    }

    @PutMapping("/{id}")
    public PartnerContactResponse updatePartnerContact(@Valid @RequestBody ContactPRequest request,
                                         @PathVariable Long id){
        return partnerContactService.updatePartnerContact(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePartnerPartnerContact(@PathVariable Long id){
        partnerContactService.deletePartnerContact(id);
    }
}