package com.csidigital.dao.entity;

import com.csidigital.shared.enumeration.WorkModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WorkArrangement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private WorkModel workModel ;
    private Double dailyWage;
    private Long workingDaysWorking ;

    @ManyToOne
    private Benefit benefit;
}
