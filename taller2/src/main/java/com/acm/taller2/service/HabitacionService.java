package com.acm.taller2.service;

import com.acm.taller2.persistence.entities.HabitacionEntity;
import com.acm.taller2.persistence.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitacionService {
    private HabitacionRepository habitacionRepository;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public HabitacionEntity saveHabitacion(HabitacionEntity habitacion) {
        HabitacionEntity habitacionEntity = habitacionRepository.save(habitacion);
        return habitacionEntity;
        }

        public void deleteById(Long id) {
            habitacionRepository.deleteById(id);
        }

        public HabitacionEntity findById(Long id) {
            HabitacionEntity habitacionEntity = habitacionRepository.findById(id).orElse(null);
            return habitacionEntity;
        }

        public HabitacionEntity updateHabitacion(HabitacionEntity habitacion) {
            HabitacionEntity habitacionEntity =  habitacionRepository.save(habitacion);
            return habitacionEntity;
        }

        public List<HabitacionEntity> findAll() {
            return habitacionRepository.findAll().stream().map(HabitacionMapper::entityToModel).collect(Collectors.toList());
        }
    }
}
