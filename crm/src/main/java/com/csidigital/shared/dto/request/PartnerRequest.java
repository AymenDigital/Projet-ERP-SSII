package com.csidigital.shared.dto.request;

import com.csidigital.dao.entity.Address;
import com.csidigital.dao.entity.OfferedService;

import com.csidigital.dao.entity.Partner;
import com.csidigital.dao.entity.Requirement;
import com.csidigital.shared.enumeration.*;

import jakarta.persistence.OneToMany;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data

public class PartnerRequest {

    private String name ;
    private CompanyStatus companyStatus ;
    private Integer staffNumber;
    private String parentCompany;

    private String ceoName ;
    private String ceoLastName ;
    private Long phoneNumber ;
    private Long phoneNumberTwo ;
    private RefPhoneNumber refPhoneNumber;
    private RefPhoneNumber refPhoneNumber2;
    private Integer postCode ;
    private String city ;
    private Country country ;
    private String description ;
    private WorkField workField ;
    private LegalStatus legalStatus ;
    private String logo ;
    private LocalDate activityStartDate;
    private LocalDate activityEndDate;
    private LocalDate partnerShipDate;
    private Provenance provenance ;

    private List<Requirement> requirements ;


    private List<Address> addresses;

    private List<OfferedService> offeredServices;
}
