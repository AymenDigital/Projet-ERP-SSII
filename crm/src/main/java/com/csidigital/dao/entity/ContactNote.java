package com.csidigital.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class ContactNote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private LocalDate contactDate;
    private String  subject;
    private String comment;
    private String discussionNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Contact contact;
}
