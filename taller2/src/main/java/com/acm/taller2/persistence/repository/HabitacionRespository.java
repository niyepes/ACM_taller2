package com.acm.taller2.persistence.repository;

import com.acm.taller2.persistence.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRespository extends JpaRepository<Habitacion,Long> {
}
