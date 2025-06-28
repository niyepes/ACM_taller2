package com.acm.taller2.service;

import com.acm.taller2.model.Administrador;
import com.acm.taller2.persistence.entities.AdministradorEntity;
import com.acm.taller2.persistence.repository.AdministradorRepository;
import com.acm.taller2.mappers.AdministradorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorService {
    private final AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public AdministradorEntity saveAdministrador(AdministradorEntity administrador) {
        return administradorRepository.save(administrador);
    }

    public void deleteById(Long id) {
        administradorRepository.deleteById(id);
    }

    public Administrador findById(Long id) {
        AdministradorEntity administradorEntity = administradorRepository.findById(id).orElse(null);
        return administradorEntity != null ? AdministradorMapper.entityToModel(administradorEntity) : null;
    }

    public Administrador updateAdministrador(Administrador administrador) {
        AdministradorEntity administradorEntity =  administradorRepository.save(AdministradorMapper.modelToEntity(administrador));
        return AdministradorMapper.entityToModel(administradorEntity);
    }

    public List<Administrador> findAll() {
        return administradorRepository.findAll().stream().map(AdministradorMapper::entityToModel).collect(Collectors.toList());
    }
}
