package com.csidigital.shared.dto.response;

import com.csidigital.dao.entity.Appointment;
import com.csidigital.dao.entity.ContactNote;
import com.csidigital.dao.entity.Partner;
import com.csidigital.shared.enumeration.Civility;
import com.csidigital.shared.enumeration.Privilege;
import com.csidigital.shared.enumeration.Service;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ContactResponse {
    private Long contactId;
    @Enumerated(EnumType.STRING)
    private Civility civility;
    private String lastName;
    private String firstName;
    private String fullName;
    private String localisation;
    private String function;
    private String societe ;
    private String service;
    private String emailOne;
    private String emailTwo;
    private Long phoneNumberOne;
    private Long phoneNumberTwo;
    private String comment;
    @Nullable
    @Enumerated(EnumType.STRING)
    private Privilege privilege;
    private Long partnerId ;
    private List<ContactNote> contactNotes;
    private List<Appointment> appointments;
}
