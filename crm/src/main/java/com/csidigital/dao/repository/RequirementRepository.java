package com.csidigital.dao.repository;

import com.csidigital.dao.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement , Long> {
    List<Requirement> findByPartnerId(Long id);
}
