package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.*;
import com.csidigital.dao.entity.Partner;
import com.csidigital.dao.entity.Partner;
import com.csidigital.dao.repository.PartnerRepository;
import com.csidigital.shared.dto.request.PartnerRequest;
import com.csidigital.dao.entity.Partner;
import com.csidigital.shared.dto.response.*;
import com.csidigital.shared.dto.response.PartnerResponse;
import com.csidigital.shared.dto.response.PartnerResponse;
import com.csidigital.shared.dto.response.PartnerResponse;
import com.csidigital.shared.exceptions.ResourceNotFoundException;
import com.csidigital.dao.repository.PartnerRepository;
import com.csidigital.management.service.PartnerService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PartnerServiceImpl implements PartnerService {
   @Autowired
   private PartnerRepository partnerRepository ;
  
   @Autowired
   private ModelMapper modelMapper;

   @Override
   public PartnerResponse createPartner(PartnerRequest request) {
      Partner partner = modelMapper.map(request, Partner.class);
      Partner partnerSaved = partnerRepository.save(partner);
      return modelMapper.map(partnerSaved, PartnerResponse.class);
   }

   @Override
   public List<PartnerResponse> getAllPartners() {
      List<Partner> partners = partnerRepository.findAll();
      List<PartnerResponse> partnerList = new ArrayList<>();

      for (Partner partner : partners) {
         PartnerResponse response = modelMapper.map(partner, PartnerResponse.class);
         partnerList.add(response);
      }

      return partnerList;
   }

   @Override
   public PartnerResponse getPartnerById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      PartnerResponse partnerResponse = modelMapper.map(partner, PartnerResponse.class);
      return partnerResponse;
   }

   @Override
   public PartnerResponse updatePartner(PartnerRequest request, Long id) {
      Partner existingPartner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id: " + id + " not found"));
      modelMapper.map(request, existingPartner);
      Partner savedPartner = partnerRepository.save(existingPartner);
      return modelMapper.map(savedPartner, PartnerResponse.class);
   }

   @Override
   public void deletePartner(Long id) {
 partnerRepository.deleteById(id);
   }
}
