package com.acm.taller2.service;

import com.acm.taller2.mappers.TipoHabitacionMapper;
import com.acm.taller2.model.TipoHabitacion;
import com.acm.taller2.persistence.entities.TipoHabitacionEntity;
import com.acm.taller2.persistence.repository.TipoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoHabitacionService {

    private TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    public TipoHabitacionService(TipoHabitacionRepository tipoHabitacionRepository) {
        this.tipoHabitacionRepository = tipoHabitacionRepository;
    }

    public TipoHabitacion saveTipoHabitacion(TipoHabitacion tipoHabitacion) {
        TipoHabitacionEntity tipoHabitacionEntity = tipoHabitacionRepository.save(TipoHabitacionMapper.modelToEntity(tipoHabitacion));
        return TipoHabitacionMapper.entityToModel(tipoHabitacionEntity);
    }

    public void deleteById(Long id) {
        tipoHabitacionRepository.deleteById(id);
    }

    public TipoHabitacion findById(Long id) {
        TipoHabitacionEntity tipoHabitacionEntity = tipoHabitacionRepository.findById(id).orElse(null);
        return tipoHabitacionEntity != null ? TipoHabitacionMapper.entityToModel(tipoHabitacionEntity) : null;
    }

    public TipoHabitacion updateTipoHabitacion(TipoHabitacion tipoHabitacion) {
        TipoHabitacionEntity tipoHabitacionEntity =  tipoHabitacionRepository.save(TipoHabitacionMapper.modelToEntity(tipoHabitacion));
        return TipoHabitacionMapper.entityToModel(tipoHabitacionEntity);
    }

    public List<TipoHabitacion> findAll() {
        return tipoHabitacionRepository.findAll().stream().map(TipoHabitacionMapper::entityToModel).collect(Collectors.toList());
    }
}
