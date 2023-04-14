package com.csidigital.finance.dao.entity;

import com.csidigital.finance.shared.enumeration.ActivationStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Integer level;
    private Long total;
    @Enumerated(EnumType.STRING)
    private ActivationStatus activationStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "treasury_id")
    @JsonBackReference

    private Treasury treasury;
}
