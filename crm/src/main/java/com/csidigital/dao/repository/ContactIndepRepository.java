package com.csidigital.dao.repository;

import com.csidigital.dao.entity.Contact;
import com.csidigital.dao.entity.ContactIndep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactIndepRepository extends JpaRepository<ContactIndep,Long> {
}
