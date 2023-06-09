package com.csidigital.management.service;

import com.csidigital.dao.entity.*;
import com.csidigital.shared.dto.request.PartnerRequest;

import com.csidigital.shared.dto.response.PartnerResponse;
import com.csidigital.shared.dto.response.RequirementResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Optional;

public interface PartnerService {
    PartnerResponse createPartner( PartnerRequest request);
    List<PartnerResponse> getAllPartners();
    PartnerResponse getPartnerById(Long id);
     List<Requirement> getPartnerReqById(Long id) ;
    List<Address> getPartnerAddressById(Long id);
    List<Contact> getPartnerContactsById(Long id) ;
    List<SocialMedia> getPartnerSocialMediasById(Long id);
    List<OfferedService> getPartnerOfferedServicesById(Long id);
    List<BankAccount> getPartnerBankAccountsById(Long id);
    PartnerResponse updatePartner(PartnerRequest partnerRequest , Long id );

    void deletePartner(Long id);
}
