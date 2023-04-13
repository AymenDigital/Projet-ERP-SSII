package com.csidigital.finance.shared.dto.Request;

import com.csidigital.finance.shared.enumeration.ActivationStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryDtoRequest {

    private String title;
    private Integer level;
    private Long total;
    private ActivationStatus activationStatus;
    private  Long treasuryId ;
}
