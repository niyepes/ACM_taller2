package com.acm.taller2.persistence.repository;

import acm.taller2.persistence.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity,Long> {
}
