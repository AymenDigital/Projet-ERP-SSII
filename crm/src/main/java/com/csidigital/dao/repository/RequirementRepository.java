package com.csidigital.dao.repository;

import com.csidigital.dao.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement , Long> {

}
