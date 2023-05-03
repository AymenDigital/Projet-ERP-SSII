package com.csidigital.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ContactIndep extends Contact implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "contactIndep", cascade = CascadeType.ALL)
    private List<ContactIndepBankAccount> bankAccounts;
}
