package com.csidigital.management.service;

import com.csidigital.shared.dto.response.ContactResponse;

import java.util.List;

public interface ContactService {
    ContactResponse createContact(ContactRequest request);
    List<ContactResponse> getAllContacts();
    ContactResponse getContactById(Long id);

    ContactResponse updateContact(ContactRequest request, Long id);

    void deleteContact(Long id);
}
