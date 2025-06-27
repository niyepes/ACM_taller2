package com.acm.taller2.persistence;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tipo_habitacion")
public class TipoHabitacionEntity implements Serializable {

    @Id
    @Column(name = "id_tipo_habitacion")
    private Long id;
    private String nombre;
    private Integer cantidad;

    public TipoHabitacionEntity() {
    }

    public TipoHabitacionEntity(long id, String nombre, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
