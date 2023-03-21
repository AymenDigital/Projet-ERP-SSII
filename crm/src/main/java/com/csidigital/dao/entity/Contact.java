package com.csidigital.dao.entity;

import com.csidigital.shared.enumeration.Civility;
import com.csidigital.shared.enumeration.Privilege;
import com.csidigital.shared.enumeration.Service;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    @Enumerated(EnumType.STRING)
    private Civility civility;
    private String lastName;
    private String firstName;
    private String function;
    @Enumerated(EnumType.STRING)
    private Service service;
    private String emailOne;
    private String emailTwo;
    private Long phoneNumberOne;
    private Long phoneNumberTwo;
    private String comment;
    @Enumerated(EnumType.STRING)
    private Privilege privilege;

    @JsonIgnore
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<ContactNote> contactNotes;

    @JsonIgnore
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Partner partner ;


}
