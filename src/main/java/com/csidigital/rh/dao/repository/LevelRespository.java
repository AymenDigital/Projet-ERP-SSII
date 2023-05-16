package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Language;
import com.csidigital.rh.dao.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRespository extends JpaRepository<Level, Long> {

}
