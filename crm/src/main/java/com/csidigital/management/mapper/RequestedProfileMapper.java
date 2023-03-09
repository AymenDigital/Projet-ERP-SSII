package com.csidigital.management.mapper;

import com.csidigital.dao.entity.RequestedProfile;
import com.csidigital.shared.dto.request.RequestedProfileRequest;
import com.csidigital.shared.dto.response.RequestedProfileResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component

public class RequestedProfileMapper {
    public RequestedProfileResponse toRequestedProfileResponseDto(RequestedProfile requestedProfile){
        RequestedProfileResponse requestedProfileResponse= new RequestedProfileResponse();
        BeanUtils.copyProperties(requestedProfile, requestedProfileResponse);
        return requestedProfileResponse ;
    }
    public RequestedProfile torequestedProfile(RequestedProfileRequest requestedProfileRequest){
        RequestedProfile requestedProfile= new RequestedProfile();
        BeanUtils.copyProperties(requestedProfileRequest, requestedProfile);
        return requestedProfile ;}
}
