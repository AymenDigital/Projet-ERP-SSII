package com.csidigital.finance.dao.repository;

import com.csidigital.finance.dao.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection,Long> {
}
