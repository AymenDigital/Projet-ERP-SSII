package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.*;
import com.csidigital.dao.repository.PartnerRepository;
import com.csidigital.shared.dto.request.PartnerRequest;
import com.csidigital.shared.dto.response.PartnerResponse;

import com.csidigital.management.service.PartnerService;
import com.csidigital.shared.dto.response.RequirementResponse;
import com.csidigital.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PartnerServiceImpl implements PartnerService {
   @Autowired
   private PartnerRepository partnerRepository ;
   @Autowired
   private ModelMapper modelMapper;

   @Override
   public PartnerResponse createPartner( PartnerRequest request) {

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
   public List<Requirement> getPartnerReqById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      List<Requirement> requirement = partner.getRequirements();
      //RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
      return requirement;
   }
   @Override
   public List<Address> getPartnerAddressById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      List<Address> address = partner.getAddresses();
      //RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
      return address;
   }

   @Override
   public List<Contact> getPartnerContactsById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      List<Contact> partnerContacts = partner.getContacts();
      //RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
      return partnerContacts;
   }

   @Override
   public List<SocialMedia> getPartnerSocialMediasById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      List<SocialMedia> socialMedia = partner.getSocialMedias();
      //RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
      return socialMedia;
   }

   @Override
   public List<OfferedService> getPartnerOfferedServicesById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      List<OfferedService> offeredServices = partner.getOfferedServices();
      return offeredServices;
   }

   @Override
   public List<BankAccount> getPartnerBankAccountsById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      List<BankAccount> bankAccounts = partner.getBankAccounts();
      return bankAccounts;
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
