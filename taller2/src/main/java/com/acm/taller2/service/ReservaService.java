package com.acm.taller2.service;

import com.acm.taller2.mappers.ReservaMapper;
import com.acm.taller2.model.Reserva;
import com.acm.taller2.persistence.entities.ReservaEntity;
import com.acm.taller2.persistence.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva saveReserva(Reserva reserva) {
        ReservaEntity reservaEntity = reservaRepository.save(ReservaMapper.modelToEntity(reserva));
        return ReservaMapper.entityToModel(reservaEntity);
    }

    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    public Reserva findById(Long id) {
        ReservaEntity reservaEntity = reservaRepository.findById(id).orElse(null);
        return reservaEntity != null ? ReservaMapper.entityToModel(reservaEntity) : null;
    }

    public Reserva updateReserva(Reserva reserva) {
        ReservaEntity reservaEntity =  reservaRepository.save(ReservaMapper.modelToEntity(reserva));
        return ReservaMapper.entityToModel(reservaEntity);
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll().stream().map(ReservaMapper::entityToModel).collect(Collectors.toList());
    }
}
