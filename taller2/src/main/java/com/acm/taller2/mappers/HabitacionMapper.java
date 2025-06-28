package com.acm.taller2.mappers;

import com.acm.taller2.dto.HabitacionDTO;
import com.acm.taller2.model.Habitacion;
import com.acm.taller2.model.Hotel;
import com.acm.taller2.model.TipoHabitacion;
import com.acm.taller2.persistence.entities.HabitacionEntity;
import com.acm.taller2.persistence.entities.HotelEntity;
import com.acm.taller2.persistence.entities.TipoHabitacionEntity;

public class HabitacionMapper {
    public static HabitacionDTO modelToDto(Habitacion habitacion){
       return HabitacionDTO.builder()
               .id(habitacion.getId())
               .numeroHabitacion(habitacion.getNumeroHabitacion())
               .precioDia(habitacion.getPrecioDia())
               .disponible(habitacion.getDisponible())
               .idhotel(Hotel.builder().id(habitacion.getHotelID()).build().getId())
               .idTipoHabitacion(TipoHabitacion.builder().id(habitacion.getTipoHabitacionID()).build().getId())
               .build();
    }
    public static Habitacion dtoToModel(HabitacionDTO habitacion){
        return Habitacion.builder()
                .id(habitacion.getId())
                .numeroHabitacion(habitacion.getNumeroHabitacion())
                .precioDia(habitacion.getPrecioDia())
                .disponible(habitacion.getDisponible())
                .hotelID(habitacion.getIdhotel())
                .tipoHabitacionID(habitacion.getIdTipoHabitacion())
                .build();
    }
    public static HabitacionEntity modelToEntity(Habitacion habitacion){
        return HabitacionEntity.builder()
                .id(habitacion.getId())
                .numeroHabitacion(habitacion.getNumeroHabitacion())
                .precioDia(habitacion.getPrecioDia())
                .disponible(habitacion.getDisponible())
                .hotel(HotelEntity.builder().id(habitacion.getHotelID()).build())
                .tipoHabitacion(TipoHabitacionEntity.builder().id(habitacion.getTipoHabitacionID()).build())
                .build();
    }
    public static Habitacion entityToModel(HabitacionEntity habitacion){
        return Habitacion.builder()
                .id(habitacion.getId())
                .numeroHabitacion(habitacion.getNumeroHabitacion())
                .precioDia(habitacion.getPrecioDia())
                .disponible(habitacion.getDisponible())
                .hotelID(habitacion.getHotel().getId())
                .tipoHabitacionID(habitacion.getTipoHabitacion().getId())
                .build();
    }
}
