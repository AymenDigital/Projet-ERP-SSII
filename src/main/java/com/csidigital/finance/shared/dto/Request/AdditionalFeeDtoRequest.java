package com.csidigital.finance.shared.dto.Request;

import com.csidigital.finance.dao.entity.Bill;
import com.csidigital.finance.shared.enumeration.AdditionalFeeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AdditionalFeeDtoRequest {
    private String description;

    private Double cost;

    private Long tva;

    private Integer quantity;

    private AdditionalFeeType additionalFeeType;

    private Long billId ;

}
