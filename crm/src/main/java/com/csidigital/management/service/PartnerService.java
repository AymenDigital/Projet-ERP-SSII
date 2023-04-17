package com.csidigital.management.service;

import com.csidigital.dao.entity.Contact;
import com.csidigital.dao.entity.Requirement;
import com.csidigital.shared.dto.request.PartnerRequest;

import com.csidigital.shared.dto.response.PartnerResponse;
import com.csidigital.shared.dto.response.RequirementResponse;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Optional;

public interface PartnerService {
    PartnerResponse createPartner( PartnerRequest request/*,MultipartFile file*/ );
    List<PartnerResponse> getAllPartners();
    PartnerResponse getPartnerById(Long id);
     List<Requirement> getPartnerReqById(Long id) ;
    List<Contact> getPartnerContactById(Long id) ;
    PartnerResponse updatePartner(PartnerRequest partnerRequest , Long id );

    void deletePartner(Long id);
}
