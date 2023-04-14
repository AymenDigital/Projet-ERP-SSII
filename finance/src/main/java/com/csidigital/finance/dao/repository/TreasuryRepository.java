package com.csidigital.finance.dao.repository;

import com.csidigital.finance.dao.entity.Treasury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreasuryRepository extends JpaRepository<Treasury,Long> {
}
