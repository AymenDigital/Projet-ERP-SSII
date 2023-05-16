package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Level;
import com.csidigital.rh.dao.entity.Offer;
import com.csidigital.rh.dao.entity.Question;
import com.csidigital.rh.dao.entity.Skills;
import com.csidigital.rh.dao.repository.LevelRespository;
import com.csidigital.rh.dao.repository.OfferRepository;
import com.csidigital.rh.management.service.LevelService;
import com.csidigital.rh.shared.dto.request.LevelRequest;
import com.csidigital.rh.shared.dto.response.LevelResponse;
import com.csidigital.rh.shared.dto.response.OfferResponse;
import com.csidigital.rh.shared.dto.response.QuestionResponse;
import com.csidigital.rh.shared.dto.response.SkillsResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class LevelImpl implements LevelService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LevelRespository levelRespository ;

    @Override
    public LevelResponse createLevel(LevelRequest request) {
        Level level = modelMapper.map(request, Level.class);
        Level levelSaved = levelRespository.save(level);
        return modelMapper.map(levelSaved, LevelResponse.class);
    }

    @Override
    public List<LevelResponse> getAllLevels() {
        List<Level> levels = levelRespository.findAll();
        List<LevelResponse> levelResponses = new ArrayList<>();


        for (Level level: levels) {
            LevelResponse response = modelMapper.map(level, LevelResponse.class);
            levels.add(level);
        }

        return levelResponses;    }

    @Override
    public LevelResponse getLevelById(Long id) {
        Level level = levelRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("level with id " + id + " not found"));
        LevelResponse levelResponse = modelMapper.map(level, LevelResponse.class);
        return levelResponse;
    }

    @Override
    public LevelResponse updateLevel(LevelRequest request, Long id) {
        Level existingLevel = levelRespository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Level with id: " + id + " not found"));
        modelMapper.map(request, existingLevel);
        existingLevel.setId(id);
        Level savedLevel = levelRespository.save(existingLevel);
        return modelMapper.map(savedLevel, LevelResponse.class);    }

    @Override
    public void deleteLevel(Long id) {
        levelRespository.deleteById(id);
    }
}
