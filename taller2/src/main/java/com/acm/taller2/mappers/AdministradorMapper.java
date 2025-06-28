package com.acm.taller2.mappers;

import com.acm.taller2.dto.AdministradorDTO;
import com.acm.taller2.model.Administrador;
import com.acm.taller2.persistence.entities.AdministradorEntity;

public class AdministradorMapper {
    public static AdministradorDTO modelToDto(Administrador administrador) {
        return AdministradorDTO.builder()
                .id(administrador.getId())
                .primerNombre(administrador.getPrimerNombre())
                .segundoNombre(administrador.getSegundoNombre())
                .primerApellido(administrador.getPrimerApellido())
                .segundoApellido(administrador.getSegundoApellido())
                .correo(administrador.getCorreo())
                .telefono(administrador.getTelefono())
                .build();
    }
    public static Administrador dtoToModel(AdministradorDTO administrador) {
        return  Administrador.builder()
                .id(administrador.getId())
                .primerNombre(administrador.getPrimerNombre())
                .segundoNombre(administrador.getSegundoNombre())
                .primerApellido(administrador.getPrimerApellido())
                .segundoApellido(administrador.getSegundoApellido())
                .correo(administrador.getCorreo())
                .telefono(administrador.getTelefono())
                .build();
    }
    public static AdministradorEntity modelToEntity(Administrador administrador) {
        return AdministradorEntity.builder()
                .id(administrador.getId())
                .primerNombre(administrador.getPrimerNombre())
                .segundoNombre(administrador.getSegundoNombre())
                .primerApellido(administrador.getPrimerApellido())
                .segundoApellido(administrador.getSegundoApellido())
                .correo(administrador.getCorreo())
                .telefono(administrador.getTelefono())
                .build();
    }
    public static Administrador entityToModel(AdministradorEntity administrador) {
        return Administrador.builder()
                .id(administrador.getId())
                .primerNombre(administrador.getPrimerNombre())
                .segundoNombre(administrador.getSegundoNombre())
                .primerApellido(administrador.getPrimerApellido())
                .segundoApellido(administrador.getSegundoApellido())
                .correo(administrador.getCorreo())
                .telefono(administrador.getTelefono())
                .build();
    }
}
