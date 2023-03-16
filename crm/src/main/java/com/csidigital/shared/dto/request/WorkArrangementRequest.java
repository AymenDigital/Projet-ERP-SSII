package com.csidigital.shared.dto.request;


import com.csidigital.dao.entity.Benefit;
import com.csidigital.shared.enumeration.WorkModel;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data

public class WorkArrangementRequest {
    private WorkModel workModel ;
    private Double dailyWage;
    private Long workingDaysNumber ;


    private Long benefitNum;
}
