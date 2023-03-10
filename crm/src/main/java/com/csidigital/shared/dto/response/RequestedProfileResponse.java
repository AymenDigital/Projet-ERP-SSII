package com.csidigital.shared.dto.response;

import lombok.Data;

@Data
public class RequestedProfileResponse {
    private Long id ;
    private Integer candidateNumber;
    private String missionPlace;
}
