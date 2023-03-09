package com.csidigital.dao.entity;


import com.csidigital.shared.enumeration.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private CompanyStatus companyStatus ;
    private int staffNumber;
    private String parentCompany;

    private String ceoName ;
    private String ceoLastName ;
    private Long phoneNumber ;
    private Long phoneNumberTwo ;
    private RefPhoneNumber refPhoneNumber;
    private RefPhoneNumber refPhoneNumber2;
    private int postCode ;
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

    @OneToMany(mappedBy = "partner")
    List<Address> addresses;
    @OneToMany(mappedBy = "partner")
    List<OfferedService> offeredServices;
}
