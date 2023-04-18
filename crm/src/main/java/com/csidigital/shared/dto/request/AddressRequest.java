package com.csidigital.shared.dto.request;


import lombok.Data;


@Data

public class AddressRequest {
    private String addressTitle ;
    private String street ;
    private Long partnerNum;
}
