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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public PartnerResponse createPartner(@RequestParam("file") MultipartFile file , @ModelAttribute PartnerRequest partnerRequest){


        return partnerService.createPartner(file , partnerRequest);
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
    @GetMapping(path = "/logo/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getPartnerLogo(@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "\\Desktop\\CSI Training\\crm\\upload-dir\\" + fileName));
    }

}
