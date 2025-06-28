package com.acm.taller2.service;

import com.acm.taller2.mappers.PagoMapper;
import com.acm.taller2.model.Pago;
import com.acm.taller2.persistence.entities.PagoEntity;
import com.acm.taller2.persistence.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class PagoService {
    private final PagoRepository pagoRepository;

    @Autowired
    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public Pago savePago(Pago pago) {
        PagoEntity pagoEntity = pagoRepository.save(PagoMapper.modelToEntity(pago));
        return PagoMapper.entityToModel(pagoEntity);
    }

    public void deleteById(Long id) {
        pagoRepository.deleteById(id);
    }

    public Pago findById(Long id) {
        PagoEntity pagoEntity = pagoRepository.findById(id).orElse(null);
        return pagoEntity != null ? PagoMapper.entityToModel(pagoEntity) : null;
    }

    public Pago updatePago(Pago pago) {
        PagoEntity pagoEntity =  pagoRepository.save(PagoMapper.modelToEntity(pago));
        return PagoMapper.entityToModel(pagoEntity);
    }

    public List<Pago> findAll() {
        return pagoRepository.findAll().stream().map(PagoMapper::entityToModel).collect(Collectors.toList());
    }
}
