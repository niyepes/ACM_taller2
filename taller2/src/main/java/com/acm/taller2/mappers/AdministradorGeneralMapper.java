package com.acm.taller2.mappers;

import com.acm.taller2.dto.AdministradorGeneralDTO;
import com.acm.taller2.model.AdministradorGeneral;
import com.acm.taller2.persistence.entities.AdministradorGeneralEntity;

public class AdministradorGeneralMapper {
    public static AdministradorGeneralDTO modelToDto(AdministradorGeneral administradorGeneral) {
        return AdministradorGeneralDTO.builder()
                .id(administradorGeneral.getId())
                .correo(administradorGeneral.getCorreo())
                .telefono(administradorGeneral.getTelefono())
                .primerNombre(administradorGeneral.getPrimerNombre())
                .segundoNombre(administradorGeneral.getSegundoNombre())
                .primerApellido(administradorGeneral.getPrimerApellido())
                .segundoApellido(administradorGeneral.getSegundoApellido())
                .build();
    }
    public static AdministradorGeneral dtoToModel(AdministradorGeneralDTO administradorGeneral) {
        return  AdministradorGeneral.builder()
                .id(administradorGeneral.getId())
                .correo(administradorGeneral.getCorreo())
                .telefono(administradorGeneral.getTelefono())
                .primerNombre(administradorGeneral.getPrimerNombre())
                .segundoNombre(administradorGeneral.getSegundoNombre())
                .primerApellido(administradorGeneral.getPrimerApellido())
                .segundoApellido(administradorGeneral.getSegundoApellido())
                .build();
    }
    public static AdministradorGeneral  entityToModel(AdministradorGeneralEntity administradorGeneral) {
        return AdministradorGeneral.builder()
                .id(administradorGeneral.getId())
                .correo(administradorGeneral.getCorreo())
                .telefono(administradorGeneral.getTelefono())
                .primerNombre(administradorGeneral.getPrimerNombre())
                .segundoNombre(administradorGeneral.getSegundoNombre())
                .primerApellido(administradorGeneral.getPrimerApellido())
                .segundoApellido(administradorGeneral.getSegundoApellido())
                .build();
    }

    public static AdministradorGeneralEntity modelToEntity(AdministradorGeneral administradorGeneral) {
        return AdministradorGeneralEntity.builder()
                .id(administradorGeneral.getId())
                .correo(administradorGeneral.getCorreo())
                .telefono(administradorGeneral.getTelefono())
                .primerNombre(administradorGeneral.getPrimerNombre())
                .segundoNombre(administradorGeneral.getSegundoNombre())
                .primerApellido(administradorGeneral.getPrimerApellido())
                .segundoApellido(administradorGeneral.getSegundoApellido())
                .build();
    }
}
