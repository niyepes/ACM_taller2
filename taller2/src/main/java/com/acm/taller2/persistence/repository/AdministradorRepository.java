package com.acm.taller2.persistence.repository;

import acm.taller2.persistence.entities.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity,Long> {
}
