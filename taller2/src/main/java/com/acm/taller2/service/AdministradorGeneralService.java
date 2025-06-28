package com.acm.taller2.service;

import com.acm.taller2.mappers.AdministradorGeneralMapper;
import com.acm.taller2.model.AdministradorGeneral;
import com.acm.taller2.persistence.entities.AdministradorGeneralEntity;
import com.acm.taller2.persistence.repository.AdministradorGeneralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorGeneralService {
    private final AdministradorGeneralRepository administradorGeneralRepository;

    @Autowired
    public AdministradorGeneralService(AdministradorGeneralRepository administradorGeneralRepository) {
        this.administradorGeneralRepository = administradorGeneralRepository;
    }

    public AdministradorGeneral saveAdministradorGeneral(AdministradorGeneral administradorGeneral) {
        AdministradorGeneralEntity administradorGeneralEntity = administradorGeneralRepository.save(AdministradorGeneralMapper.modelToEntity(administradorGeneral));
        return AdministradorGeneralMapper.entityToModel(administradorGeneralEntity);
    }

    public void deleteById(Long id) {
        administradorGeneralRepository.deleteById(id);
    }

    public AdministradorGeneral findById(Long id) {
        AdministradorGeneralEntity administradorGeneralEntity = administradorGeneralRepository.findById(id).orElse(null);
        return administradorGeneralEntity != null ? AdministradorGeneralMapper.entityToModel(administradorGeneralEntity) : null;
    }

    public AdministradorGeneral updateAdministradorGeneral(AdministradorGeneral administradorGeneral) {
        AdministradorGeneralEntity administradorGeneralEntity =  administradorGeneralRepository.save(AdministradorGeneralMapper.modelToEntity(administradorGeneral));
        return AdministradorGeneralMapper.entityToModel(administradorGeneralEntity);
    }

    public List<AdministradorGeneral> findAll() {
        return administradorGeneralRepository.findAll().stream().map(AdministradorGeneralMapper::entityToModel).collect(Collectors.toList());
    }
}
