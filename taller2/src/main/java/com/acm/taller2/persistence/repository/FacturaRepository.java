package com.acm.taller2.persistence.repository;

import com.acm.taller2.persistence.entities.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<FacturaEntity,Long> {
}
