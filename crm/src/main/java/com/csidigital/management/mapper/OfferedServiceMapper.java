package com.csidigital.management.mapper;

import com.csidigital.dao.entity.OfferedService;
import com.csidigital.dao.entity.Order;
import com.csidigital.shared.dto.request.OfferedServiceRequest;
import com.csidigital.shared.dto.request.OrderRequest;
import com.csidigital.shared.dto.response.OfferedServiceResponse;
import com.csidigital.shared.dto.response.OrderResponse;
import org.springframework.beans.BeanUtils;

public class OfferedServiceMapper {
    public OfferedServiceResponse toOfferedServiceResponseDto(OfferedService OfferedService){
        OfferedServiceResponse offeredServiceResponse= new OfferedServiceResponse();
        BeanUtils.copyProperties(offeredServiceResponse, offeredServiceResponse);
        return offeredServiceResponse ;
    }
    public OfferedService toofferedService(OfferedServiceRequest offeredServiceRequest){
        OfferedService offeredService= new OfferedService();
        BeanUtils.copyProperties(offeredServiceRequest, offeredService);
        return offeredService ;
    }
}
