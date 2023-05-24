package com.csidigital.finance.dao.repository;

import com.csidigital.finance.dao.entity.BillClient;
import com.csidigital.finance.dao.entity.FeeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeClientRepository extends JpaRepository<FeeClient,Long> {
    @Query("SELECT COALESCE(SUM(a.priceWithAllTaxIncluded), 0) FROM FeeClient a WHERE a.billClient = :billClient")
    Double calculateTotalAmountByBillClient(@Param("billClient") BillClient billClient);

    @Query("SELECT COALESCE(SUM(a.priceWithAllTaxIncluded), 0) FROM FeeClient a WHERE a.billClient = :billClient")
    Double calculateTotalWithDiscountByBillClient(@Param("billClient") BillClient billClient);
}
