package com.csidigital.management.service;

import com.csidigital.shared.dto.request.ContactPRequest;
import com.csidigital.shared.dto.response.PartnerContactResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ContactPService {
    public PartnerContactResponse createPartnerContact(@RequestBody ContactPRequest contactPRequest);
    public List<PartnerContactResponse>getAllPartnerContacts();
    public PartnerContactResponse getPartnerContactById(@RequestParam Long id);
    public PartnerContactResponse updatePartnerContact(@RequestParam Long id,
                                                       @RequestBody ContactPRequest contactPRequest);
    public void deletePartnerContact(@RequestParam Long id);
}
