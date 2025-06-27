package com.acm.taller2.service;

import com.acm.taller2.persistence.repository.HabitacionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitacionService {
    private HabitacionRespository habitacionRespository;

    @Autowired
    public HabitacionService(HabitacionRespository habitacionRespository) {
        this.habitacionRespository = habitacionRespository;
    }
}
