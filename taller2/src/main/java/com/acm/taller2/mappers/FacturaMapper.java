package com.acm.taller2.mappers;

import com.acm.taller2.dto.FacturaDTO;
import com.acm.taller2.model.Factura;
import com.acm.taller2.model.Pago;
import com.acm.taller2.model.Reserva;
import com.acm.taller2.persistence.entities.FacturaEntity;
import com.acm.taller2.persistence.entities.PagoEntity;
import com.acm.taller2.persistence.entities.ReservaEntity;

public class FacturaMapper {
    public static FacturaDTO modelToDto(Factura factura){
        return FacturaDTO.builder()
                .id(factura.getId())
                .idreserva(Reserva.builder().id(factura.getReservaID()).build().getId())
                .idpago(Pago.builder().id(factura.getPagoID()).build().getId())
                .valorTotal(factura.getValorTotal())
                .fechaEmision(factura.getFechaEmision())
                .build();
    }
    public static Factura dtoToModel(FacturaDTO factura){
        return Factura.builder()
                .id(factura.getId())
                .reservaID(factura.getIdreserva())
                .pagoID(factura.getIdpago())
                .valorTotal(factura.getValorTotal())
                .fechaEmision(factura.getFechaEmision())
                .build();
    }
    public static FacturaEntity modelToEntity(Factura factura){
        return FacturaEntity.builder()
                .id(factura.getId())
                .reserva(ReservaEntity.builder().id(factura.getReservaID()).build())
                .pago(PagoEntity.builder().id(factura.getPagoID()).build())
                .valorTotal(factura.getValorTotal())
                .fechaEmision(factura.getFechaEmision())
                .build();
    }
    public static Factura entityToModel(FacturaEntity factura){
        return Factura.builder()
                .id(factura.getId())
                .pagoID(factura.getPago().getId())
                .reservaID(factura.getReserva().getId())
                .valorTotal(factura.getValorTotal())
                .fechaEmision(factura.getFechaEmision())
                .build();
    }
}
