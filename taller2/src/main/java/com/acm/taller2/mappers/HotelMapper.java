package com.acm.taller2.mappers;

import com.acm.taller2.dto.HotelDTO;
import com.acm.taller2.model.Hotel;
import com.acm.taller2.persistence.entities.HotelEntity;

public class HotelMapper {
    public static HotelDTO modelToDto(Hotel product) {
        return HotelDTO.builder()
                .id(product.getId())
                .nombre(product.getNombre())
                .ciudad(product.getCiudad())
                .telefono(product.getTelefono())
                .correo(product.getCorreo())
                .direccion(product.getDireccion())
                .build();
    }

    public static Hotel dtoToModel(HotelDTO product) {
        return Hotel.builder()
                .id(product.getId())
                .nombre(product.getNombre())
                .ciudad(product.getCiudad())
                .telefono(product.getTelefono())
                .correo(product.getCorreo())
                .direccion(product.getDireccion())
                .build();
    }

    public static HotelEntity modelToEntity(Hotel product) {
        return HotelEntity.builder()
                .id(product.getId())
                .nombre(product.getNombre())
                .ciudad(product.getCiudad())
                .telefono(product.getTelefono())
                .correo(product.getCorreo())
                .direccion(product.getDireccion())
                .build();
    }

    public static Hotel entityToModel(HotelEntity product) {
        return Hotel.builder()
                .id(product.getId())
                .nombre(product.getNombre())
                .ciudad(product.getCiudad())
                .telefono(product.getTelefono())
                .correo(product.getCorreo())
                .direccion(product.getDireccion())
                .build();
    }
}
