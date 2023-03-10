package com.csidigital.shared.dto.request;


import com.csidigital.dao.entity.Contact;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;


@Data

public class ContactNoteRequest {
    private LocalDate contactDate;
    private String  subject;
    private String comment;
    private String discussionNote;
    private Duration duration;

    private Contact contact;
}
