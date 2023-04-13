package com.csidigital.finance.shared.dto.Response;


import com.csidigital.finance.shared.enumeration.AdditionalFeeType;
import lombok.Data;


@Data
public class AdditionalFeeDtoResponse<D extends Number> {
    private long id;

    private String description;

    private Double cost;

    private Long tva;

    private Integer quantity;

    private AdditionalFeeType additionalFeeType;

    private Long billId ;

}
