package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.Contact;
import com.csidigital.dao.repository.ContactRepository;
import com.csidigital.management.service.ContactService;
import com.csidigital.shared.dto.request.ContactRequest;
import com.csidigital.shared.dto.response.ContactResponse;

import com.csidigital.shared.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactResponse createContact(ContactRequest request) {
        Contact contact = modelMapper.map(request, Contact.class);
        Contact contactSaved = contactRepository.save(contact);
        return modelMapper.map(contactSaved, ContactResponse.class);
    }

    @Override
    public List<ContactResponse> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactResponse> contactList = new ArrayList<>();

        for (Contact contact : contacts) {
            ContactResponse response = modelMapper.map(contact, ContactResponse.class);
            contactList.add(response);
        }

        return contactList;
    }

    @Override
    public ContactResponse getContactById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Contact with id " +id+ " not found"));
        ContactResponse contactResponse = modelMapper.map(contact, ContactResponse.class);
        return contactResponse;
    }

    @Override
    public ContactResponse updateContact(ContactRequest request, Long id) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Contact with id: " + id + " not found"));
        modelMapper.map(request, existingContact);
        Contact savedContact = contactRepository.save(existingContact);
        return modelMapper.map(savedContact, ContactResponse.class);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
