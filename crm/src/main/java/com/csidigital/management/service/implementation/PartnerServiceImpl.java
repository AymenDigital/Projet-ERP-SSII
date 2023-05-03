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
   @Autowired
   private StorageService storageService;

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
   public List<Requirement> getPartnerReqById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      List<Requirement> requirement = partner.getRequirements();
      //RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
      return requirement;
   }
   public List<ContactPartner> getPartnerContactById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      List<ContactPartner> partnerContacts = partner.getPartnerContacts();
      //RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
      return partnerContacts;
   }
   public List<Address> getPartnerAddressById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      List<Address> address = partner.getAddresses();
      //RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
      return address;
   }
   public List<SocialMedia> getPartnerSocialMediasById(Long id) {
      Partner partner = partnerRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Partner with id " +id+ " not found"));
      List<SocialMedia> socialMedia = partner.getSocialMedias();
      //RequirementResponse requirementResponse = modelMapper.map(requirement, RequirementResponse.class);
      return socialMedia;
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

   @Override
   public ResponseEntity<?> uploadImage(Long id, MultipartFile file) {
      try {
         // Get the partner object by ID from the database
         Partner partner = partnerRepository.findById(id)
                 .orElse(partner = null);
         // Check if the partner exists
         if (partner == null) {
            return ResponseEntity.notFound().build();
         }
         // Check if the file is not empty and is an image
         if (file.isEmpty() || !file.getContentType().startsWith("image/")) {
            return ResponseEntity.badRequest().build();
         }
         // Save the image to a file on the server
         String fileName = StringUtils.cleanPath(file.getOriginalFilename());
         String uploadDir = "partner-logos/" + id;
         String fileExtension = fileName.substring(fileName.lastIndexOf("."));
         String newFileName = UUID.randomUUID().toString() + fileExtension;
         Path uploadPath = Paths.get(uploadDir);
         if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
         }
         try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(newFileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
         }
         // Update the user object with the new image file name
         partner.setLogo(newFileName);
         partnerRepository.save(partner);
         return ResponseEntity.ok().build();
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }

   @Override
   public ResponseEntity<byte[]> getImage(Long id) {
      // Get the user object by ID from the database
      Partner partner = partnerRepository.findById(id)
              .orElse(partner = null);
      // Check if the user exists and has an image
      if (partner == null || partner.getLogo() == null) {
         return ResponseEntity.notFound().build();
      }
      try {
         // Read the image file from disk
         Path imagePath = Paths.get("partner-logos/" + id + "/" + partner.getLogo());
         byte[] imageBytes = Files.readAllBytes(imagePath);
         // Set the response headers to indicate the image content type
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.IMAGE_JPEG);
         // Return the image data as a ResponseEntity with the appropriate headers
         return new ResponseEntity<byte[]>(imageBytes, headers, HttpStatus.OK);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }


}
