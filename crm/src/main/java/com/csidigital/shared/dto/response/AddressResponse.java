package com.csidigital.shared.dto.response;

import com.csidigital.shared.enumeration.AddressType;
import lombok.Data;

@Data
public class AddressResponse {
   private  Long Id ;
   private int num;
   private String street ;
   private String city ;
   private String region;
   private String country ;
   private AddressType type;
   private Long partnerId;
}
