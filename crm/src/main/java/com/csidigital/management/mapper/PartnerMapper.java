package com.csidigital.management.mapper;

import com.csidigital.dao.entity.Partner;
import com.csidigital.dao.entity.Requirement;
import com.csidigital.shared.dto.request.PartnerRequest;
import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.response.PartnerResponse;
import com.csidigital.shared.dto.response.RequirementResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component

public class PartnerMapper {
    public PartnerResponse toPartnerResponseDto(Partner partner){
        PartnerResponse partnerResponse= new PartnerResponse();
        BeanUtils.copyProperties(partner, partnerResponse);
        return  partnerResponse ;
    }
    public Partner toPartner(PartnerRequest partnerRequest){
        Partner partner= new Partner();
        BeanUtils.copyProperties(partnerRequest, partner);
        return partner ;
}}
