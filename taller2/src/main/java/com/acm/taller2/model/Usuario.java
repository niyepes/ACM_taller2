package com.acm.taller2.model;

import lombok.Builder;

@Builder
public class Usuario {
    private Long id;
    private String nombreUsuario;
    private String contrasena;
    private String rol;
    private Long clienteID;
    private Long empleadoID;
    private Long administradorGeneralID;
    private Long administradorID;

    public Usuario(Long id, String nombreUsuario, String contrasena, String rol, Long clienteID, Long empleadoID, Long administradorGeneralID, Long administradorID) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.clienteID = clienteID;
        this.empleadoID = empleadoID;
        this.administradorGeneralID = administradorGeneralID;
        this.administradorID = administradorID;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public Long getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(Long empleadoID) {
        this.empleadoID = empleadoID;
    }

    public Long getAdministradorGeneralID() {
        return administradorGeneralID;
    }

    public void setAdministradorGeneralID(Long administradorGeneralID) {
        this.administradorGeneralID = administradorGeneralID;
    }

    public Long getAdministradorID() {
        return administradorID;
    }

    public void setAdministradorID(Long administradorID) {
        this.administradorID = administradorID;
    }
}
