package com.csidigital.finance.shared.dto.Request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class FeeClientDtoRequest {
    private String refFree;
    private String designation;
    private String unite;
    private Double cost;
    private Long tva;
    private Integer quantity;
    private Long discount;

    private Long billClientId;

}
