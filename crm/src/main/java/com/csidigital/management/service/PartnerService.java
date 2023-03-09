package com.csidigital.management.service;

import com.csidigital.shared.dto.request.PartnerRequest;
import com.csidigital.dao.entity.Partner;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PartnerService {
    Partner create(Partner partner);
    List<Partner> get();
    Optional<Partner> getById(Long id);

    ResponseEntity<Partner> update(PartnerRequest partnerRequest , Long id );

    void delete(Long id);
}
