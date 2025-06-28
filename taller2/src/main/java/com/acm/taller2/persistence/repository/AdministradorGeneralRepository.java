package com.acm.taller2.persistence.repository;


import com.acm.taller2.persistence.entities.AdministradorGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorGeneralRepository extends JpaRepository<AdministradorGeneralEntity,Long> {
}
