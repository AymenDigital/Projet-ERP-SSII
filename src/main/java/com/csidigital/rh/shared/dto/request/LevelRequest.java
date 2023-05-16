package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.QuestionCategory;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data

public class LevelRequest {

    private String name ;

    private List<QuestionCategory> questionCategories;
}
