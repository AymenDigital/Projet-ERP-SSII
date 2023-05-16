package com.csidigital.rh.shared.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ContractRequest {

    private LocalDate startDate;
    private LocalDate endDate;

    private String contractPlace;
    private LocalDate contractDate;
    private Byte[] entrepriseSignature;
    private Byte[] ressourceSignature;
}
