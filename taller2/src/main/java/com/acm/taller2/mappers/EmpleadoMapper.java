package com.acm.taller2.mappers;

import com.acm.taller2.dto.EmpleadoDTO;
import com.acm.taller2.model.Empleado;
import com.acm.taller2.persistence.entities.EmpleadoEntity;

public class EmpleadoMapper {
    public static EmpleadoDTO modelToDto(Empleado empleado) {
        return EmpleadoDTO.builder()
                .id(empleado.getId())
                .correo(empleado.getCorreo())
                .telefono(empleado.getTelefono())
                .primerNombre(empleado.getPrimerNombre())
                .segundoNombre(empleado.getSegundoNombre())
                .primerApellido(empleado.getPrimerApellido())
                .segundoApellido(empleado.getSegundoApellido())
                .build();
    }
    public static Empleado dtoToModel(EmpleadoDTO empleado) {
        return  Empleado.builder()
                .id(empleado.getId())
                .correo(empleado.getCorreo())
                .telefono(empleado.getTelefono())
                .primerNombre(empleado.getPrimerNombre())
                .segundoNombre(empleado.getSegundoNombre())
                .primerApellido(empleado.getPrimerApellido())
                .segundoApellido(empleado.getSegundoApellido())
                .build();
    }
    public static EmpleadoEntity modelToEntity(Empleado empleado) {
        return EmpleadoEntity.builder()
                .id(empleado.getId())
                .correo(empleado.getCorreo())
                .telefono(empleado.getTelefono())
                .primerNombre(empleado.getPrimerNombre())
                .segundoNombre(empleado.getSegundoNombre())
                .primerApellido(empleado.getPrimerApellido())
                .segundoApellido(empleado.getSegundoApellido())
                .build();
    }
    public static Empleado entityToModel(EmpleadoEntity empleado) {
        return Empleado.builder()
                .id(empleado.getId())
                .correo(empleado.getCorreo())
                .telefono(empleado.getTelefono())
                .primerNombre(empleado.getPrimerNombre())
                .segundoNombre(empleado.getSegundoNombre())
                .primerApellido(empleado.getPrimerApellido())
                .segundoApellido(empleado.getSegundoApellido())
                .build();
    }
}
