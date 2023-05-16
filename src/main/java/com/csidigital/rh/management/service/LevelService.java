package com.csidigital.rh.management.service;

import com.csidigital.rh.dao.entity.Level;
import com.csidigital.rh.shared.dto.request.LevelRequest;
import com.csidigital.rh.shared.dto.request.OfferRequest;
import com.csidigital.rh.shared.dto.response.LevelResponse;
import com.csidigital.rh.shared.dto.response.OfferResponse;

import java.util.List;

public interface LevelService {
    LevelResponse createLevel(LevelRequest request);
    List<LevelResponse> getAllLevels();
    LevelResponse getLevelById(Long id);

    LevelResponse updateLevel(LevelRequest request, Long id);

    void deleteLevel(Long id);
}
