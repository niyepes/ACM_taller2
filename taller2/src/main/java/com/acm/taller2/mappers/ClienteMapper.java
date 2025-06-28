package com.acm.taller2.mappers;

import com.acm.taller2.dto.ClienteDTO;
import com.acm.taller2.model.Cliente;
import com.acm.taller2.persistence.entities.ClienteEntity;

public class ClienteMapper {
    public static ClienteDTO modelToDto(Cliente cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .primerNombre(cliente.getPrimerNombre())
                .segundoNombre(cliente.getSegundoNombre())
                .primerApellido(cliente.getPrimerApellido())
                .segundoApellido(cliente.getSegundoApellido())
                .cedula(cliente.getCedula())
                .direccion(cliente.getDireccion())
                .build();
    }
    public static Cliente dtoToModel(ClienteDTO cliente) {
        return  Cliente.builder()
                .id(cliente.getId())
                .primerNombre(cliente.getPrimerNombre())
                .segundoNombre(cliente.getSegundoNombre())
                .primerApellido(cliente.getPrimerApellido())
                .segundoApellido(cliente.getSegundoApellido())
                .cedula(cliente.getCedula())
                .direccion(cliente.getDireccion())
                .build();
    }
    public static ClienteEntity modelToEntity(Cliente cliente) {
        return ClienteEntity.builder()
                .id(cliente.getId())
                .primerNombre(cliente.getPrimerNombre())
                .segundoNombre(cliente.getSegundoNombre())
                .primerApellido(cliente.getPrimerApellido())
                .segundoApellido(cliente.getSegundoApellido())
                .cedula(cliente.getCedula())
                .direccion(cliente.getDireccion())
                .build();
    }
    public static Cliente entityToModel(ClienteEntity cliente) {
        return Cliente.builder()
                .id(cliente.getId())
                .primerNombre(cliente.getPrimerNombre())
                .segundoNombre(cliente.getSegundoNombre())
                .primerApellido(cliente.getPrimerApellido())
                .segundoApellido(cliente.getSegundoApellido())
                .cedula(cliente.getCedula())
                .direccion(cliente.getDireccion())
                .build();
    }
}
