package com.acm.taller2.service;

import com.acm.taller2.persistence.repository.TipoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoHabitacionService {

    private TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    public TipoHabitacionService(TipoHabitacionRepository tipoHabitacionRepository) {
        this.tipoHabitacionRepository = tipoHabitacionRepository;
    }
}
