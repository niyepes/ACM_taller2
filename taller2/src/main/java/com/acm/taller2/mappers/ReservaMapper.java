package com.acm.taller2.mappers;

import com.acm.taller2.dto.ReservaDTO;
import com.acm.taller2.model.Cliente;
import com.acm.taller2.model.Habitacion;
import com.acm.taller2.model.Reserva;
import com.acm.taller2.persistence.entities.ClienteEntity;
import com.acm.taller2.persistence.entities.HabitacionEntity;
import com.acm.taller2.persistence.entities.ReservaEntity;

public class ReservaMapper {
    public static ReservaDTO modelToDto(Reserva reserva){
        return ReservaDTO.builder()
                .id(reserva.getId())
                .fechaInicio(reserva.getFechaInicio())
                .fechaFinal(reserva.getFechaFinal())
                .cantidadDias(reserva.getCantidadDias())
                .estado(reserva.getEstado())
                .fechaReserva(reserva.getFechaReserva())
                .idhabitacion(Habitacion.builder().id(reserva.getHabitacionID()).build().getId())
                .idcliente(Cliente.builder().id(reserva.getClienteID()).build().getId())
                .build();
    }
    public static Reserva dtoToModel(ReservaDTO reserva){
        return Reserva.builder()
                .id(reserva.getId())
                .fechaInicio(reserva.getFechaInicio())
                .fechaFinal(reserva.getFechaFinal())
                .cantidadDias(reserva.getCantidadDias())
                .estado(reserva.getEstado())
                .fechaReserva(reserva.getFechaReserva())
                .habitacionID(reserva.getIdhabitacion())
                .clienteID(reserva.getIdcliente())
                .build();
    }
    public static ReservaEntity modelToEntity(Reserva reserva){
        return ReservaEntity.builder()
                .id(reserva.getId())
                .fechaInicio(reserva.getFechaInicio())
                .fechaFinal(reserva.getFechaFinal())
                .cantidadDias(reserva.getCantidadDias())
                .estado(reserva.getEstado())
                .fechaReserva(reserva.getFechaReserva())
                .habitacion(HabitacionEntity.builder().id(reserva.getHabitacionID()).build())
                .cliente(ClienteEntity.builder().id(reserva.getClienteID()).build())
                .build();
    }
    public static Reserva entityToModel(ReservaEntity reserva){
        return Reserva.builder()
                .id(reserva.getId())
                .fechaInicio(reserva.getFechaInicio())
                .fechaFinal(reserva.getFechaFinal())
                .cantidadDias(reserva.getCantidadDias())
                .estado(reserva.getEstado())
                .fechaReserva(reserva.getFechaReserva())
                .habitacionID(reserva.getHabitacion().getId())
                .clienteID(reserva.getCliente().getId())
                .build();
    }
}
