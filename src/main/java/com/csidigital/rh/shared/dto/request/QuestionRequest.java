package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.ExperienceLevel;
import com.csidigital.rh.shared.enumeration.InterviewType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class QuestionRequest {
    private String question;
    private InterviewType interviewType;
    private Long AssQuestionInterviewId;

    private ExperienceLevel level ;
}
