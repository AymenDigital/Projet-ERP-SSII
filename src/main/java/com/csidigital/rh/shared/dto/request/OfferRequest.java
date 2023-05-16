package com.csidigital.rh.shared.dto.request;

import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class OfferRequest {
    private String title;
    private String reference;
    private String description ;
    private LocalDate startDate;
    private LocalDate endDate ;
    private String jobSite;

}
