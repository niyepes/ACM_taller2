package com.acm.taller2.persistence.repository;

import acm.taller2.persistence.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<ReservaEntity,Long> {
}
