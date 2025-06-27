package com.acm.taller2.service;

import com.acm.taller2.persistence.HotelEntity;
import com.acm.taller2.persistence.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelEntity saveHotel (HotelEntity hotelEntity){
        return hotelRepository.save(hotelEntity);
    }

    public void deleteHotel (Long id){
        hotelRepository.deleteById(id);
    }

    public HotelEntity findHotelById (Long id){
        return hotelRepository.findById(id).orElse(null);
    }

    public HotelEntity updateHotel (HotelEntity HotelEntity){
        return hotelRepository.save(new HotelEntity());
    }


}
