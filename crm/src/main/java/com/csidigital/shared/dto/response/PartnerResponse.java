package com.csidigital.shared.dto.response;

import com.csidigital.dao.entity.Address;
import com.csidigital.dao.entity.OfferedService;
import com.csidigital.shared.enumeration.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PartnerResponse {
    private Long id ;
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
    private Byte[] logo ;
    private LocalDate activityStartDate;
    private LocalDate activityEndDate;
    private LocalDate partnerShipDate;
    private Provenance provenance ;


    List<Address> addresses;

    List<OfferedService> offeredServices;
}
