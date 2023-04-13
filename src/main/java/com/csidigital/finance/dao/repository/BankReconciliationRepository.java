package com.csidigital.finance.dao.repository;

import com.csidigital.finance.dao.entity.BankReconciliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankReconciliationRepository extends JpaRepository<BankReconciliation, Long> {
}
