package com.csidigital.dao.entity;

import com.csidigital.shared.enumeration.Privilege;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ContactPartner extends Contact implements Serializable {
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner_id")
    private Partner partner ;
    @Enumerated(EnumType.STRING)
    private Privilege privilege;
}
