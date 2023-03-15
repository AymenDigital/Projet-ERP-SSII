package com.csidigital.shared.dto.request;


import com.csidigital.dao.entity.Partner;
import com.csidigital.shared.enumeration.ServiceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data

public class OfferedServiceRequest {
    private String title ;

    private ServiceType serviceType ;


    private Long partnerNum;
}
