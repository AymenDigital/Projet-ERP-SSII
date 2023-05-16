package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.Question;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class QuestionCategoryRequest {
    private String name ;

    private List<Question> questions;
    private Long LevelId;

}
