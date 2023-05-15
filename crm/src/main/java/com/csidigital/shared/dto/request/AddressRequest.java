package com.csidigital.shared.dto.request;


import com.csidigital.shared.enumeration.AddressType;
import lombok.Data;


@Data

public class AddressRequest {
    private int num;
    private String street ;
    private String city ;
    private String region;
    private String country ;
    private AddressType type;
    private Long partnerNum;
}
