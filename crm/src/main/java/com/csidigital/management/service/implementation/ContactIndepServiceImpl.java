package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.Contact;
import com.csidigital.dao.entity.ContactIndep;
import com.csidigital.dao.repository.ContactIndepRepository;
import com.csidigital.dao.repository.PartnerRepository;
import com.csidigital.management.service.ContactIndepService;
import com.csidigital.shared.dto.request.ContactIndepRequest;
import com.csidigital.shared.dto.response.ContactIndepResponse;

import com.csidigital.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ContactIndepServiceImpl implements ContactIndepService {
    @Autowired
    private ContactIndepRepository contactRepository ;
    @Autowired
    private PartnerRepository partnerRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactIndepResponse createIndepContact(ContactIndepRequest request) {
        ContactIndep contact = modelMapper.map(request, ContactIndep.class);
        ContactIndep contactSaved = contactRepository.save(contact);
        return modelMapper.map(contactSaved, ContactIndepResponse.class);
    }

    @Override
    public List<ContactIndepResponse> getAllIndepContacts() {
        List<ContactIndep> indepContacts = contactRepository.findAll();
        List<ContactIndepResponse> contactList = new ArrayList<>();

        for (ContactIndep contact : indepContacts) {
            ContactIndepResponse response = modelMapper.map(contact, ContactIndepResponse.class);
            contactList.add(response);
        }

        return contactList;
    }

    @Override
    public ContactIndepResponse getIndepContactById(Long id) {
        ContactIndep contact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Independent Contact with id " +id+ " not found"));

        ContactIndepResponse contactResponse = modelMapper.map(contact, ContactIndepResponse.class);
        return contactResponse;
    }

    @Override
    public ContactIndepResponse updateIndepContact(ContactIndepRequest request, Long id) {
        ContactIndep existingContact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Independent Contact with id: " + id + " not found"));

        modelMapper.map(request, existingContact);
        ContactIndep savedContact = contactRepository.save(existingContact);
        return modelMapper.map(savedContact, ContactIndepResponse.class);
    }

    @Override
    public void deleteIndepContact(Long id) {
        contactRepository.deleteById(id);
    }
}
