package com.csidigital.management.mapper;

import com.csidigital.dao.entity.Requirement;
import com.csidigital.shared.dto.request.RequirementRequest;
import com.csidigital.shared.dto.response.RequirementResponse;
import org.hibernate.annotations.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RequirementMapper {

    public RequirementResponse toRequirementResponseDto(Requirement requirement){
        RequirementResponse requirementResponse= new RequirementResponse();
        BeanUtils.copyProperties(requirement, requirementResponse);
        return requirementResponse ;
    }
    public Requirement toRequirement(RequirementRequest requirementRequest){
        Requirement requirement= new Requirement();
        BeanUtils.copyProperties(requirementRequest, requirement);
        return requirement ;
    }


}
