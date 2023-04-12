package com.csidigital.dao.entity;


import com.csidigital.shared.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Partner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name1;
    @Enumerated(EnumType.STRING)
    private CompanyStatus companyStatus ;
    private Integer staffNumber;
    private String parentCompany;

    private String ceoName ;
    private String ceoLastName ;
    private Long phoneNumber ;
    private Long phoneNumberTwo ;
    //@Enumerated(EnumType.STRING)
    private Long refPhoneNumber;
    //@Enumerated(EnumType.STRING)
    private Long refPhoneNumber2;
    private Integer postCode ;
    private String city ;
    //@Enumerated(EnumType.STRING)
    private String country ;
    private String description ;
    @Enumerated(EnumType.STRING)
    private WorkField workField ;
    @Enumerated(EnumType.STRING)
    private LegalStatus legalStatus ;
    private String logo ;
    private LocalDateTime activityStartDate;
    private LocalDateTime activityEndDate;
    private LocalDateTime partnerShipDate;
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
    private List<ContactPartner> contactPartners;
    @JsonIgnore
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    private List<SocialMedia> socialMedias;
}
