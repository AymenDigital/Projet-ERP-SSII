package com.csidigital.management.service;

import com.csidigital.shared.dto.request.PartnerRequest;

import com.csidigital.shared.dto.response.PartnerResponse;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Optional;

public interface PartnerService {
    PartnerResponse createPartner( PartnerRequest request/*,MultipartFile file*/ );
    List<PartnerResponse> getAllPartners();
    PartnerResponse getPartnerById(Long id);

    PartnerResponse updatePartner(PartnerRequest partnerRequest , Long id );

    void deletePartner(Long id);
}
