package com.csidigital.rh.shared.dto.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class OfferResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String title;
    private String reference;
    private String description ;
    private String requiredSkills ;
    private Long requiredExperienceAmount ;
    private LocalDate startDate;
    private LocalDate endDate ;
    private String jobSite;
    private Set<Long> employee;

}
