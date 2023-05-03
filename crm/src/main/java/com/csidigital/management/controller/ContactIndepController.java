package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.ContactIndepServiceImpl;
import com.csidigital.shared.dto.request.ContactIndepRequest;
import com.csidigital.shared.dto.response.ContactIndepResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crm/contactsIndep")
@CrossOrigin(origins = "${cross.origin.url}")
public class ContactIndepController {
    @Autowired
    private ContactIndepServiceImpl contactService ;

    @GetMapping()
    public List<ContactIndepResponse> getAllIndepContacts() {
        return contactService.getAllIndepContacts();
    }

    @GetMapping("/{id}")
    public ContactIndepResponse getIndepContactById(@PathVariable Long id){
        return contactService.getIndepContactById(id);
    }

    @PostMapping()
    public ContactIndepResponse createIndepContact(@Valid @RequestBody ContactIndepRequest request){
        return contactService.createIndepContact(request);
    }

    @PutMapping("/{id}")
    public ContactIndepResponse updateIndepContact(@Valid @RequestBody ContactIndepRequest request,
                                              @PathVariable Long id){
        return contactService.updateIndepContact(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteIndepContact(@PathVariable Long id){
        contactService.deleteIndepContact(id);
    }
}
