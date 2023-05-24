package com.csidigital.finance.dao.repository;

import com.csidigital.finance.dao.entity.Disbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisbursementRepository extends JpaRepository<Disbursement,Long> {
}
