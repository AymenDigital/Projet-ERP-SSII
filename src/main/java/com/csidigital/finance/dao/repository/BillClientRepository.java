package com.csidigital.finance.dao.repository;

import com.csidigital.finance.dao.entity.BillClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillClientRepository extends JpaRepository<BillClient,Long> {
}
