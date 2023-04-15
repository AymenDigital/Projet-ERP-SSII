package com.csidigital.dao.repository;

import com.csidigital.dao.entity.ContactPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerContactRepository extends JpaRepository<ContactPartner, Long> {
    List<ContactPartner> findByPartnerId(Long id);
}
