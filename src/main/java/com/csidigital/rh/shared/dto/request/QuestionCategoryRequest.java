package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.Question;
import com.csidigital.rh.shared.enumeration.ExperienceLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;
@Data
public class QuestionCategoryRequest {
    private String name ;

    private List<Question> questions;
    @Enumerated(EnumType.STRING)
    private ExperienceLevel level ;

}
