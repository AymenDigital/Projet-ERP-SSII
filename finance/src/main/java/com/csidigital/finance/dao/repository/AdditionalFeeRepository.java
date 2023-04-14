package com.csidigital.finance.dao.repository;

import com.csidigital.finance.dao.entity.AdditionalFee;
import com.csidigital.finance.dao.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalFeeRepository extends JpaRepository<AdditionalFee,Long> {

}
