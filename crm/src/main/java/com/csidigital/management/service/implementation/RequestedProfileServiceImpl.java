package com.csidigital.management.service.implementation;

import com.csidigital.dao.entity.RequestedProfile;
import com.csidigital.dao.repository.RequestedProfileRepository;
import com.csidigital.management.service.RequestedProfileService;
import com.csidigital.shared.dto.request.RequestedProfileRequest;
import com.csidigital.shared.dto.response.RequestedProfileResponse;
import com.csidigital.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RequestedProfileServiceImpl implements RequestedProfileService {
    @Autowired
    private RequestedProfileRepository requestedProfileRepository ;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public RequestedProfileResponse createRequestedProfile(RequestedProfileRequest request) {
        RequestedProfile requestedProfile = modelMapper.map(request, RequestedProfile.class);
        RequestedProfile requestedProfileSaved = requestedProfileRepository.save(requestedProfile);
        return modelMapper.map(requestedProfileSaved, RequestedProfileResponse.class);
    }

    @Override
    public List<RequestedProfileResponse> getAllRequestedProfiles() {
        List<RequestedProfile> requestedProfiles = requestedProfileRepository.findAll();
        List<RequestedProfileResponse> requestedProfileList = new ArrayList<>();

        for (RequestedProfile requestedProfile : requestedProfiles) {
            RequestedProfileResponse response = modelMapper.map(requestedProfile, RequestedProfileResponse.class);
            requestedProfileList.add(response);
        }

        return requestedProfileList;
    }

    @Override
    public RequestedProfileResponse getRequestedProfileById(Long id) {
        RequestedProfile requestedProfile = requestedProfileRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Requested Profile with id " +id+ " not found"));
        RequestedProfileResponse requestedProfileResponse = modelMapper.map(requestedProfile, RequestedProfileResponse.class);
        return requestedProfileResponse;
    }

    @Override
    public RequestedProfileResponse updateRequestedProfile(RequestedProfileRequest request, Long id) {
        RequestedProfile existingRequestedProfile = requestedProfileRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("RequestedProfile with id: " + id + " not found"));
        modelMapper.map(request, existingRequestedProfile);
        RequestedProfile savedRequestedProfile = requestedProfileRepository.save(existingRequestedProfile);
        return modelMapper.map(savedRequestedProfile, RequestedProfileResponse.class);
    }

    @Override
    public void deleteRequestedProfile(Long id) {
        requestedProfileRepository.deleteById(id);
    }
}
