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
    @Enumerated(EnumType.STRING)
    private CompanyStatus companyStatus ;
    private Integer staffNumber;
    private String parentCompany;

    private String ceoName ;
    private String ceoLastName ;
    private Long phoneNumber ;
    private Long phoneNumberTwo ;
    @Enumerated(EnumType.STRING)
    private RefPhoneNumber refPhoneNumber;
    @Enumerated(EnumType.STRING)
    private RefPhoneNumber refPhoneNumber2;
    private Integer postCode ;
    private String city ;
    @Enumerated(EnumType.STRING)
    private Country country ;
    private String description ;
    @Enumerated(EnumType.STRING)
    private WorkField workField ;
    @Enumerated(EnumType.STRING)
    private LegalStatus legalStatus ;
    private Byte[] logo ;
    private LocalDate activityStartDate;
    private LocalDate activityEndDate;
    private LocalDate partnerShipDate;
    @Enumerated(EnumType.STRING)
    private Provenance provenance ;
   @OneToMany(mappedBy = "partner")
   List<Requirement> requirements ;
    @OneToMany(mappedBy = "partner")
    List<Address> addresses;
    @OneToMany(mappedBy = "partner")
    List<OfferedService> offeredServices;
}
