package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.LevelImpl;
import com.csidigital.rh.management.service.impl.OfferImpl;
import com.csidigital.rh.shared.dto.request.LevelRequest;
import com.csidigital.rh.shared.dto.request.OfferRequest;
import com.csidigital.rh.shared.dto.response.LevelResponse;
import com.csidigital.rh.shared.dto.response.OfferResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/level")
public class LevelController {
    @Autowired
    private LevelImpl level ;
    @GetMapping("/getAll")
    public List<LevelResponse> getAllLevels() {
        return level.getAllLevels();
    }
    @GetMapping("/get/{id}")
    public LevelResponse getLevelById(@PathVariable Long id){
        return level.getLevelById(id);
    }
    @PostMapping("/add")
    public LevelResponse createLevel(@Valid @RequestBody LevelRequest levelRequest){
        return level.createLevel(levelRequest);
    }
    @PutMapping("/update/{id}")
    public LevelResponse updateLevel(@Valid @RequestBody LevelRequest levelRequest,
                                     @PathVariable Long id){
        return level.updateLevel(levelRequest, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteLevel(@PathVariable Long id){
        level.deleteLevel(id);
    }
}
