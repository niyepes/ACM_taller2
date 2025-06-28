package com.acm.taller2.service;

import com.acm.taller2.mappers.EmpleadoMapper;
import com.acm.taller2.model.Empleado;
import com.acm.taller2.persistence.entities.EmpleadoEntity;
import com.acm.taller2.persistence.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado saveEmpleado(Empleado empleado) {
        EmpleadoEntity empleadoEntity = empleadoRepository.save(EmpleadoMapper.modelToEntity(empleado));
        return EmpleadoMapper.entityToModel(empleadoEntity);
    }

    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }

    public Empleado findById(Long id) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findById(id).orElse(null);
        return empleadoEntity != null ? EmpleadoMapper.entityToModel(empleadoEntity) : null;
    }

    public Empleado updateEmpleado(Empleado empleado) {
        EmpleadoEntity empleadoEntity =  empleadoRepository.save(EmpleadoMapper.modelToEntity(empleado));
        return EmpleadoMapper.entityToModel(empleadoEntity);
    }

    public List<Empleado> findAll() {
        return empleadoRepository.findAll().stream().map(EmpleadoMapper::entityToModel).collect(Collectors.toList());
    }
}
