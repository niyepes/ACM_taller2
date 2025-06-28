package com.acm.taller2.mappers;

import com.acm.taller2.dto.PagoDTO;
import com.acm.taller2.model.Pago;
import com.acm.taller2.model.Reserva;
import com.acm.taller2.persistence.entities.PagoEntity;
import com.acm.taller2.persistence.entities.ReservaEntity;

public class PagoMapper {
    public static PagoDTO modelToDto(Pago pago){
        return PagoDTO.builder()
                .id(pago.getId())
                .fecha(pago.getFecha())
                .idreserva(Reserva.builder().id(pago.getReservaID()).build().getId())
                .metodoPago(pago.getMetodoPago())
                .pagoTotal(pago.getPagoTotal())
                .build();
    }
    public static Pago dtoToModel(PagoDTO pago){
        return Pago.builder()
                .id(pago.getId())
                .fecha(pago.getFecha())
                .reservaID(pago.getIdreserva())
                .metodoPago(pago.getMetodoPago())
                .pagoTotal(pago.getPagoTotal())
                .build();
    }
    public static PagoEntity modelToEntity(Pago pago){
        return PagoEntity.builder()
                .id(pago.getId())
                .fecha(pago.getFecha())
                .reserva(ReservaEntity.builder().id(pago.getReservaID()).build())
                .metodoPago(pago.getMetodoPago())
                .pagoTotal(pago.getPagoTotal())
                .build();
    }
    public static Pago entityToModel(PagoEntity pago){
        return Pago.builder()
                .id(pago.getId())
                .fecha(pago.getFecha())
                .reservaID(pago.getReserva().getId())
                .metodoPago(pago.getMetodoPago())
                .pagoTotal(pago.getPagoTotal())
                .build();
    }
}
