package com.acm.taller2.persistence.repository;

import com.acm.taller2.persistence.entities.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitacionRepository extends JpaRepository<HabitacionEntity,Long> {
}
