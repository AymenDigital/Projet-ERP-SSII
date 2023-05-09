package com.csidigital.management.controller;

import com.csidigital.dao.entity.Appointment;
import com.csidigital.dao.entity.ContactNote;
import com.csidigital.dao.entity.OfferedService;
import com.csidigital.dao.entity.SocialMedia;
import com.csidigital.management.service.implementation.ContactServiceImpl;
import com.csidigital.shared.dto.request.ContactRequest;
import com.csidigital.shared.dto.response.ContactResponse;
import com.csidigital.shared.dto.response.PartnerContactResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crm/contacts")
@CrossOrigin(origins = "${cross.origin.url}")
public class ContactController {
    @Autowired
    private ContactServiceImpl contactService;
    @GetMapping()
    public List<ContactResponse> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ContactResponse getContactById(@PathVariable Long id){
        return contactService.getContactById(id);
    }

    @GetMapping("/{id}/appointments")
    public List<Appointment> getPartnerSocialMediasById(@PathVariable Long id){
        return contactService.getContactAppointmentsById(id);
    }

    @GetMapping("/{id}/contactNotes")
    public List<ContactNote> getPartnerOfferedServicesById(@PathVariable Long id){
        return contactService.getContactNotesById(id);
    }

    @PostMapping()
    public ContactResponse createContact(@Valid @RequestBody ContactRequest request){
        return contactService.createContact(request);
    }

    @PutMapping("/{id}")
    public ContactResponse updateContact(@Valid @RequestBody ContactRequest request,
                                         @PathVariable Long id){
        return contactService.updateContact(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
    }
}