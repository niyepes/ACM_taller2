package com.acm.taller2.service;

import com.acm.taller2.mappers.HotelMapper;
import com.acm.taller2.model.Hotel;
import com.acm.taller2.persistence.entities.HotelEntity;
import com.acm.taller2.persistence.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelEntity saveHotel(HotelEntity hotelEntity) {
        return hotelRepository.save(hotelEntity);
    }

    public void deleteById(Long id) {
        hotelRepository.deleteById(id);
    }

    public Hotel findById(Long id) {
        HotelEntity hotelEntity = hotelRepository.findById(id).orElse(null);
        return hotelEntity != null ? HotelMapper.entityToModel(hotelEntity) : null;
    }

    public Hotel updateHotel(Hotel hotel) {
        HotelEntity hotelEntity =  hotelRepository.save(HotelMapper.modelToEntity(hotel));
        return HotelMapper.entityToModel(hotelEntity);
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll().stream().map(HotelMapper::entityToModel).collect(Collectors.toList());
    }
}
