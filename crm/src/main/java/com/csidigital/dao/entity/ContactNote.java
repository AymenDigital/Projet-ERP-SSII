package com.csidigital.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class ContactNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private LocalDate contactDate;
    private String  subject;
    private String comment;
    private String discussionNote;
    private Duration duration;

    @ManyToOne
    private Contact contact;
}
