package com.csidigital.shared.dto.response;

import lombok.Data;

@Data
public class PartnerBankAccountResponse {
    private Long id;
    private Long rib;
    private String bankName;
    private Long partnerId;
}
