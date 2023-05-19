package com.csidigital.dao.entity;


import com.csidigital.shared.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Partner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long ref;

    //identifiant Siret ou RNE
    private Long legalIdentifier;

    //identifiant TVA
    private Long tvaIdentifier;

    private Long nafCode;
    private String name ;
    @Enumerated(EnumType.STRING)
    private CompanyStatus companyStatus ;
    private Integer staffNumber;
    private String parentCompany;
    private String email;
    private String webSite;
    private String ceoFullName ;
    private Long phoneNumber ;
    private Long mobilePhoneNumber ;
    private String comment ;
    @Enumerated(EnumType.STRING)
    private WorkField workField ;
    @Enumerated(EnumType.STRING)
    private LegalStatus legalStatus ;
    @Lob
    private String logo ;
    private LocalDate activityStartDate;
    private LocalDate activityEndDate;
    private LocalDate partnerShipDate;
    private double inProgressAuthorized;
    private ControlType controlType;
    private InsurancePolicy insurancePolicy;
    private LocalDate foundedSince;
    private String devise;
    private double capital;
    private String majorShareHolder;
    private PaymentMode paymentMode;
    private PaymentCondition paymentCondition;
    private boolean blocked;
    private String reason;
    @Enumerated(EnumType.STRING)
    private Provenance provenance ;


    @JsonIgnore
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    private List<Address> addresses;
    @JsonIgnore
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    private List<OfferedService> offeredServices;
    @JsonIgnore
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    private List<Requirement> requirements;

    @JsonIgnore
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    private List<Contact> contacts ;
    @JsonIgnore
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    private List<SocialMedia> socialMedias ;

    @JsonIgnore
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    private List<BankAccount> bankAccounts;
}
