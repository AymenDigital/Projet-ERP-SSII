package com.csidigital.shared.dto.response;

import lombok.Data;

@Data
public class BankAccountResponse {
    private Long id;
    private Long rib;
    private String bankName;
    private Long partnerId;
}
