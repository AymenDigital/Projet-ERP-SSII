package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.PartnerServiceImpl;
import com.csidigital.management.service.implementation.StorageService;
import com.csidigital.shared.dto.request.PartnerRequest;
import com.csidigital.shared.dto.response.PartnerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/crm/partners")
@CrossOrigin("*")
public class PartnerController {
    @Autowired
    private PartnerServiceImpl partnerService ;
    @Autowired
    private StorageService storageService;

    @GetMapping()
    public List<PartnerResponse> getAllPartners() {
        return partnerService.getAllPartners();
    }

    @GetMapping("/{id}")
    public PartnerResponse getPartnerById(@PathVariable Long id){
        return partnerService.getPartnerById(id);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public PartnerResponse createPartner(@RequestParam("file") MultipartFile file , PartnerRequest partnerRequest){
        storageService.store(file);
        partnerRequest.setLogo(file.getOriginalFilename());
        return partnerService.createPartner(partnerRequest);
    }
    private final java.nio.file.Path rootLocation = java.nio.file.Paths.get("upload-dir");

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
