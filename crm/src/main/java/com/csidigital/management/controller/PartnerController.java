package com.csidigital.management.controller;

import com.csidigital.dao.entity.*;
import com.csidigital.management.service.implementation.PartnerServiceImpl;
import com.csidigital.shared.dto.request.PartnerRequest;
import com.csidigital.shared.dto.response.PartnerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/crm/partners")
@CrossOrigin(origins = "${cross.origin.url}")
public class PartnerController {
    @Autowired
    private PartnerServiceImpl partnerService ;

    @GetMapping()
    public List<PartnerResponse> getAllPartners() {
        return partnerService.getAllPartners();
    }

    @GetMapping("/{id}")
    public PartnerResponse getPartnerById(@PathVariable Long id){
        return partnerService.getPartnerById(id);
    }
    @GetMapping("/{id}/requirements")
    public List<Requirement> getPartnerReqById(@PathVariable Long id){
        return partnerService.getPartnerReqById(id);
    }
    @GetMapping("/{id}/contacts")
    public List<Contact> getPartnerContactById(@PathVariable Long id){
        return partnerService.getPartnerContactsById(id);
    }
    @GetMapping("/{id}/addresses")
    public List<Address> getPartnerAddressById(@PathVariable Long id){
        return partnerService.getPartnerAddressById(id);
    }
    @GetMapping("/{id}/socialMedias")
    public List<SocialMedia> getPartnerSocialMediasById(@PathVariable Long id){
        return partnerService.getPartnerSocialMediasById(id);
    }

    @GetMapping("/{id}/offered")
    public List<OfferedService> getPartnerOfferedServicesById(@PathVariable Long id){
        return partnerService.getPartnerOfferedServicesById(id);
    }

    @PostMapping()
    public PartnerResponse createPartner(@RequestBody PartnerRequest partnerRequest){


        return partnerService.createPartner( partnerRequest);
    }

    @PutMapping("/{id}")
    public PartnerResponse updatePartner(@Valid @RequestBody PartnerRequest partnerRequest,
                                                 @PathVariable Long id){
        return partnerService.updatePartner(partnerRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deletePartner(@PathVariable Long id){
        partnerService.deletePartner(id);
    }


}
