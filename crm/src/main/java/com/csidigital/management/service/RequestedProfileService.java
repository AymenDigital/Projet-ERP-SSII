package com.csidigital.management.service;

import com.csidigital.shared.dto.request.RequestedProfileRequest;
import com.csidigital.shared.dto.request.WorkArrangementRequest;
import com.csidigital.shared.dto.response.RequestedProfileResponse;
import com.csidigital.shared.dto.response.WorkArrangementResponse;

import java.util.List;

public interface RequestedProfileService {
   RequestedProfileResponse createRequestedProfile(RequestedProfileRequest requestedProfileRequest);
    List<RequestedProfileResponse> getAllRequestedProfiles();
    RequestedProfileResponse getRequestedProfileById(Long id);

    RequestedProfileResponse updateRequestedProfile(RequestedProfileRequest requestedProfileRequest, Long id );

    void deleteRequestedProfile(Long id);
}
