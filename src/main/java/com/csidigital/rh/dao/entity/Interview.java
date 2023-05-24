package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.InterviewLocation;
import com.csidigital.rh.shared.enumeration.InterviewMode;
import com.csidigital.rh.shared.enumeration.InterviewType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Interview {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private LocalDate interviewDate;
    private LocalTime interviewTime;
    private String duration;
    private String comment;
    private String globalMark;
    private String interviewerName;
    private String interviewerEmail;
    private String interviewerPhoneNumber;
    private String interviewPlace;
    @Enumerated(EnumType.STRING)
    private InterviewLocation interviewLocation ;
    @Enumerated(EnumType.STRING)
    private InterviewType interviewType;
    @Enumerated(EnumType.STRING)
    private InterviewMode interviewMode;


    @OneToMany(mappedBy = "interview")
    private List<AssQuestionInterview> assQuestionInterviewList;
}


