package com.csidigital.management.controller;

import com.csidigital.management.service.implementation.RequestedProfileServiceImpl;
import com.csidigital.shared.dto.request.RequestedProfileRequest;
import com.csidigital.shared.dto.response.RequestedProfileResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requestedProfile")
public class RequestedProfileController {
    @Autowired
    private RequestedProfileServiceImpl requestedProfileService ;

    @GetMapping()
    public List<RequestedProfileResponse> getAllRequestedProfiles() {
        return requestedProfileService.getAllRequestedProfiles();
    }

    @GetMapping("/{id}")
    public RequestedProfileResponse getRequestedProfileById(@PathVariable Long id){
        return requestedProfileService.getRequestedProfileById(id);
    }

    @PostMapping()
    public RequestedProfileResponse createRequestedProfile(@Valid @RequestBody RequestedProfileRequest requestedProfileRequest){
        return requestedProfileService.createRequestedProfile(requestedProfileRequest);
    }

    @PutMapping("/{id}")
    public RequestedProfileResponse updateRequestedProfile(@Valid @RequestBody RequestedProfileRequest requestedProfileRequest,
                                                 @PathVariable Long id){
        return requestedProfileService.updateRequestedProfile(requestedProfileRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRequestedProfile(@PathVariable Long id){
        requestedProfileService.deleteRequestedProfile(id);
    }

}
