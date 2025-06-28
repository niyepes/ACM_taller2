package com.acm.taller2.persistence.repository;

import com.acm.taller2.persistence.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity,Long> {
}
