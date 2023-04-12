package com.csidigital.shared.dto.request;

import com.csidigital.dao.entity.*;

import com.csidigital.shared.enumeration.*;

import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data

public class PartnerRequest {

    private String name1;
    private CompanyStatus companyStatus ;
    private Integer staffNumber;
    private String parentCompany;

    private String ceoName ;
    private String ceoLastName ;
    private Long phoneNumber ;
    private Long phoneNumberTwo ;
    private Long refPhoneNumber;
    private Long refPhoneNumber2;
    private Integer postCode ;
    private String city ;
    private String country ;
    private String description ;
    private WorkField workField ;
    private LegalStatus legalStatus ;
    private String logo ;
    private LocalDate activityStartDate;
    private LocalDate activityEndDate;
    private LocalDate partnerShipDate;
    private Provenance provenance ;

    private List<Requirement> requirements ;

    private List<ContactPartner> contactPartners;

    private List<Address> addresses;

    private List<OfferedService> offeredServices;
    private List<SocialMedia> socialMedias;

}
