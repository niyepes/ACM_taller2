package com.acm.taller2.mappers;

import com.acm.taller2.dto.TipoHabitacionDTO;
import com.acm.taller2.model.Hotel;
import com.acm.taller2.model.TipoHabitacion;
import com.acm.taller2.persistence.entities.HotelEntity;
import com.acm.taller2.persistence.entities.TipoHabitacionEntity;

public class TipoHabitacionMapper {
    public static TipoHabitacionDTO modelToDto(TipoHabitacion tipoHabitacion) {
        return TipoHabitacionDTO.builder()
                .id(tipoHabitacion.getId())
                .nombre(tipoHabitacion.getNombre())
                .cantidad(tipoHabitacion.getCantidad())
                .idhotel(Hotel.builder().id(tipoHabitacion.getHotelID()).build().getId())
                .build();
    }

    public static TipoHabitacion dtoToModel(TipoHabitacionDTO tipoHabitacion) {
        return TipoHabitacion.builder()
                .id(tipoHabitacion.getId())
                .nombre(tipoHabitacion.getNombre())
                .cantidad(tipoHabitacion.getCantidad())
                .hotelID(tipoHabitacion.getIdhotel())
                .build();
    }

    public static TipoHabitacionEntity modelToEntity(TipoHabitacion tipoHabitacion) {
        return TipoHabitacionEntity.builder()
                .id(tipoHabitacion.getId())
                .nombre(tipoHabitacion.getNombre())
                .cantidad(tipoHabitacion.getCantidad())
                .hotel(HotelEntity.builder().id(tipoHabitacion.getHotelID()).build())
                .build();
    }

    public static TipoHabitacion entityToModel(TipoHabitacionEntity tipoHabitacion) {
        return TipoHabitacion.builder()
                .id(tipoHabitacion.getId())
                .nombre(tipoHabitacion.getNombre())
                .cantidad(tipoHabitacion.getCantidad())
                .hotelID(tipoHabitacion.getHotel().getId())
                .build();
    }
}
