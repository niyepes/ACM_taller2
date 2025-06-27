package com.acm.taller2.persistence.repository;

import com.acm.taller2.persistence.TipoHabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacionEntity, Long> {
}
