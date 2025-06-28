package com.acm.taller2.mappers;

import com.acm.taller2.dto.UsuarioDTO;
import com.acm.taller2.model.*;
import com.acm.taller2.persistence.entities.*;

public class UsuarioMapper {
    public static UsuarioDTO modelToDto(Usuario usuario){
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .contrasena(usuario.getContrasena())
                .rol(usuario.getRol())
                .idcliente(Cliente.builder().id(usuario.getClienteID()).build().getId())
                .idempleado(Empleado.builder().id(usuario.getEmpleadoID()).build().getId())
                .idadministradorGeneral(AdministradorGeneral.builder().id(usuario.getAdministradorGeneralID()).build().getId())
                .idadministrador(Administrador.builder().id(usuario.getAdministradorID()).build().getId())
                .build();
    }
    public static Usuario dtoToModel(UsuarioDTO usuario){
        return Usuario.builder()
                .id(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .contrasena(usuario.getContrasena())
                .rol(usuario.getRol())
                .clienteID(usuario.getIdcliente())
                .empleadoID(usuario.getIdempleado())
                .administradorGeneralID(usuario.getIdadministradorGeneral())
                .administradorID(usuario.getIdadministrador())
                .build();
    }
    public static UsuarioEntity modelToEntity(Usuario usuario){
        return UsuarioEntity.builder()
                .id(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .contrasena(usuario.getContrasena())
                .rol(usuario.getRol())
                .cliente(usuario.getClienteID() != null ? ClienteEntity.builder().id(usuario.getClienteID()).build():null)
                .empleado(usuario.getEmpleadoID() != null ? EmpleadoEntity.builder().id(usuario.getEmpleadoID()).build():null)
                .administradorGeneral(usuario.getAdministradorGeneralID() != null ? AdministradorGeneralEntity.builder().id(usuario.getAdministradorGeneralID()).build():null)
                .administrador(usuario.getAdministradorID() != null ? AdministradorEntity.builder().id(usuario.getAdministradorID()).build():null)
                .build();
    }
    public static Usuario entityToModel(UsuarioEntity usuario){
        return Usuario.builder()
                .id(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .contrasena(usuario.getContrasena())
                .rol(usuario.getRol())
                .clienteID(usuario.getCliente() != null ? usuario.getCliente().getId():null)
                .empleadoID(usuario.getEmpleado() != null ? usuario.getEmpleado().getId():null)
                .administradorGeneralID(usuario.getAdministradorGeneral() != null ? usuario.getAdministradorGeneral().getId():null)
                .administradorID(usuario.getAdministrador() != null ? usuario.getAdministrador().getId():null)
                .build();
    }
}
