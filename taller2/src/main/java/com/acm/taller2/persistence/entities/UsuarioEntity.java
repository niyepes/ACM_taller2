package com.acm.taller2.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;

@Entity
@Builder
@Table(name="usuario")
public class UsuarioEntity implements Serializable {
    @Id
    @Column(name = "id_usuario")
    private Long id;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    private String contrasena;
    private String rol;

    @ManyToOne
    @JoinColumn(name = "fk_id_cliente")
    @JsonBackReference("cliente-usuarios")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "fk_id_empleado")
    @JsonBackReference("empleado-usuarios")
    private EmpleadoEntity empleado;

    @ManyToOne
    @JoinColumn(name = "fk_id_administrador_general")
    @JsonBackReference("administradorGeneral-usuarios")
    private AdministradorGeneralEntity administradorGeneral;

    @ManyToOne
    @JoinColumn(name = "fk_id_administrador")
    @JsonBackReference("administrador-usuarios")
    private AdministradorEntity administrador;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String nombreUsuario, String contrasena, String rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
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

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    public AdministradorGeneralEntity getAdministradorGeneral() {
        return administradorGeneral;
    }

    public void setAdministradorGeneral(AdministradorGeneralEntity administradorGeneral) {
        this.administradorGeneral = administradorGeneral;
    }

    public AdministradorEntity getAdministrador() {
        return administrador;
    }

    public void setAdministrador(AdministradorEntity administrador) {
        this.administrador = administrador;
    }
}
