package com.acm.taller2.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name="empleado")
public class EmpleadoEntity implements Serializable {
    @Id
    @Column(name="id_empleado")
    private Long id;
    private String correo;
    private String telefono;
    @Column(name="primer_nombre")
    private String primerNombre;
    @Column(name ="segundo_nombre")
    private String segundoNombre;
    @Column(name ="primer_apellido")
    private String primerApellido;
    @Column(name ="segundo_apellido")
    private String segundoApellido;

    @OneToMany(mappedBy = "empleado")
    @JsonManagedReference("empleado-usuarios")
    private List<UsuarioEntity> usuarios = new ArrayList<>();

    public EmpleadoEntity() {
    }

    public EmpleadoEntity(Long id, String correo, String telefono, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        this.id = id;
        this.correo = correo;
        this.telefono = telefono;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
}
