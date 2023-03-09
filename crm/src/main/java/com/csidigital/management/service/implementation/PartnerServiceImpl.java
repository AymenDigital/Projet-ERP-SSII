package com.csidigital.management.service.implementation;

import com.csidigital.shared.dto.request.PartnerRequest;
import com.csidigital.dao.entity.Partner;
import com.csidigital.shared.exceptions.ResourceNotFoundException;
import com.csidigital.dao.repository.PartnerRepository;
import com.csidigital.management.service.PartnerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PartnerServiceImpl implements PartnerService {
   @Autowired
   private PartnerRepository partnerRepository ;
    @Override
    public Partner create(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public List<Partner> get() {
        return partnerRepository.findAll();
    }

    @Override
    public Optional<Partner> getById(Long id) {
        return partnerRepository.findById(id);
    }

    @Override
    public ResponseEntity<Partner> update(PartnerRequest partnerRequest, Long id) {
        Partner partner = partnerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
       partner.setCity(partnerRequest.getCity());
       partner.setCountry(partnerRequest.getCountry());
       partner.setAddresses(partnerRequest.getAddresses());
       partner.setName(partnerRequest.getName());
       partner.setCeoName(partnerRequest.getCeoLastName());
       partner.setCeoLastName(partnerRequest.getCeoLastName());
       partner.setActivityEndDate(partnerRequest.getActivityEndDate());
       partner.setActivityStartDate(partnerRequest.getActivityStartDate());
       partner.setLogo(partnerRequest.getLogo());
       partner.setDescription(partnerRequest.getDescription());
       partner.setLegalStatus(partnerRequest.getLegalStatus());
       partner.setWorkField(partnerRequest.getWorkField());
       partner.setStaffNumber(partnerRequest.getStaffNumber());
       partner.setRefPhoneNumber(partnerRequest.getRefPhoneNumber());
       partner.setRefPhoneNumber2(partnerRequest.getRefPhoneNumber2());
       partner.setProvenance(partnerRequest.getProvenance());
       partner.setPostCode(partnerRequest.getPostCode());
       partner.setPhoneNumber(partnerRequest.getPhoneNumber());
       partner.setPhoneNumberTwo(partnerRequest.getPhoneNumberTwo());
       partner.setPartnerShipDate(partnerRequest.getPartnerShipDate());
       partner.setParentCompany(partnerRequest.getParentCompany());
       partner.setOfferedServices(partnerRequest.getOfferedServices());
       partnerRepository.save(partner);
        return ResponseEntity.ok(partner);
    }

    @Override
    public void delete(Long id) {
    partnerRepository.deleteById(id);
    }
}
