package com.acm.taller2.persistence.repository;


import com.acm.taller2.persistence.entities.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<PagoEntity,Long> {
}
