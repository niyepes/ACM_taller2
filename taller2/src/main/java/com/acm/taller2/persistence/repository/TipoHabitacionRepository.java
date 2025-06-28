package com.acm.taller2.persistence.repository;

import com.acm.taller2.persistence.entities.TipoHabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacionEntity,Long> {
}
