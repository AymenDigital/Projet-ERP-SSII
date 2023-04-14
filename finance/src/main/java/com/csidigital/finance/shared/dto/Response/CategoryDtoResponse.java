package com.csidigital.finance.shared.dto.Response;

import com.csidigital.finance.shared.enumeration.ActivationStatus;
import lombok.Data;



@Data
public class CategoryDtoResponse {
    private Long id;
    private String title;
    private Integer level;
    private Long total;
    private ActivationStatus activationStatus;
    private  Long treasuryId ;
}
