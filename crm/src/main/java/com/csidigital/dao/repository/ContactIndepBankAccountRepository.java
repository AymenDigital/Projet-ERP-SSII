package com.csidigital.dao.repository;

import com.csidigital.dao.entity.ContactIndepBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactIndepBankAccountRepository extends JpaRepository<ContactIndepBankAccount, Long> {
}
