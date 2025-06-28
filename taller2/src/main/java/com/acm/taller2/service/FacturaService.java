package com.acm.taller2.service;

import com.acm.taller2.mappers.FacturaMapper;
import com.acm.taller2.model.Factura;
import com.acm.taller2.persistence.entities.FacturaEntity;
import com.acm.taller2.persistence.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class FacturaService {
    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public Factura saveFactura(Factura factura) {
        FacturaEntity facturaEntity = facturaRepository.save(FacturaMapper.modelToEntity(factura));
        return FacturaMapper.entityToModel(facturaEntity);
    }

    public void deleteById(Long id) {
        facturaRepository.deleteById(id);
    }

    public Factura findById(Long id) {
        FacturaEntity facturaEntity = facturaRepository.findById(id).orElse(null);
        return facturaEntity != null ? FacturaMapper.entityToModel(facturaEntity) : null;
    }

    public Factura updateFactura(Factura factura) {
        FacturaEntity facturaEntity =  facturaRepository.save(FacturaMapper.modelToEntity(factura));
        return FacturaMapper.entityToModel(facturaEntity);
    }

    public List<Factura> findAll() {
        return facturaRepository.findAll().stream().map(FacturaMapper::entityToModel).collect(Collectors.toList());
    }
}
