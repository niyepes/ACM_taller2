package com.acm.taller2.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name="cliente")
public class ClienteEntity implements Serializable {
    @Id
    @Column(name="id_cliente")
    private Long id;
    @Column(name="primer_nombre")
    private String primerNombre;
    @Column(name ="segundo_nombre")
    private String segundoNombre;
    @Column(name ="primer_apellido")
    private String primerApellido;
    @Column(name ="segundo_apellido")
    private String segundoApellido;
    private Integer cedula;
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference("cliente-reservas")
    private List<ReservaEntity> reservas =  new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference("cliente-usuarios")
    private List<UsuarioEntity> usuarios = new ArrayList<>();

    public ClienteEntity() {
    }

    public ClienteEntity(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Integer cedula, String direccion) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
