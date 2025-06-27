package com.acm.taller2.persistence.repository;

import com.acm.taller2.persistence.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity,Long> {


}
