package com.csidigital.shared.dto.response;

import com.csidigital.dao.entity.Partner;
import com.csidigital.shared.enumeration.ServiceType;
import lombok.Data;

@Data
public class OfferedServiceResponse {
    private Long id ;
    private String title ;

    private ServiceType serviceType ;


    private Partner partner;
}
