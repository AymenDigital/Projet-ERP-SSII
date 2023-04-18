package com.csidigital.management.controller;

import com.csidigital.dao.entity.Address;
import com.csidigital.dao.entity.Contact;
import com.csidigital.dao.entity.Requirement;
import com.csidigital.dao.entity.SocialMedia;
import com.csidigital.management.service.implementation.PartnerServiceImpl;
import com.csidigital.shared.dto.request.PartnerRequest;
import com.csidigital.shared.dto.response.PartnerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/crm/partners")
@CrossOrigin("*")
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
        return partnerService.getPartnerContactById(id);
    }
    @GetMapping("/{id}/addresses")
    public List<Address> getPartnerAddressById(@PathVariable Long id){
        return partnerService.getPartnerAddressById(id);
    }
    @GetMapping("/{id}/socialMedias")
    public List<SocialMedia> getPartnerSocialMediasById(@PathVariable Long id){
        return partnerService.getPartnerSocialMediasById(id);
    }

    @PostMapping(/*consumes = MediaType.MULTIPART_FORM_DATA_VALUE*/)
    public PartnerResponse createPartner(@RequestBody PartnerRequest partnerRequest /*, @RequestParam("file") MultipartFile file*/){


        return partnerService.createPartner( partnerRequest/*, file*/);
    }
    //private final java.nio.file.Path rootLocation = java.nio.file.Paths.get("upload-dir");

    @PutMapping("/{id}")
    public PartnerResponse updatePartner(@Valid @RequestBody PartnerRequest partnerRequest,
                                                 @PathVariable Long id){
        return partnerService.updatePartner(partnerRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deletePartner(@PathVariable Long id){
        partnerService.deletePartner(id);
    }
    @GetMapping(path = "/logo/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getPartnerLogo(@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "\\Desktop\\CSI Training\\crm\\upload-dir\\" + fileName));
    }

}
