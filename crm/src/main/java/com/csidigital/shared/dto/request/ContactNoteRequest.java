package com.csidigital.shared.dto.request;


import com.csidigital.dao.entity.Contact;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;


@Data

public class ContactNoteRequest {
    private String  subject;
    private String note;
    private Long contactNum;
}
