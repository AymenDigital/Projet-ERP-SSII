package com.csidigital.management.service;

import com.csidigital.shared.dto.request.ContactIndepRequest;
import com.csidigital.shared.dto.response.ContactIndepResponse;

import java.util.List;

public interface ContactIndepService {
    ContactIndepResponse createIndepContact(ContactIndepRequest request);
    List<ContactIndepResponse> getAllIndepContacts();
    ContactIndepResponse getIndepContactById(Long id);

    ContactIndepResponse updateIndepContact(ContactIndepRequest request, Long id);

    void deleteIndepContact(Long id);
}
