package com.acm.taller2.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name="tipo_habitacion")
public class TipoHabitacionEntity implements Serializable {
    @Id
    @Column(name="id_tipo_habitacion")
    private Long id;
    private String nombre;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name="fk_id_hotel")
    @JsonBackReference("hotel-tipoHabitaciones")
    private HotelEntity hotel;

    @OneToMany(mappedBy = "tipoHabitacion")
    @JsonManagedReference("tipoHabitacion-habitaciones")
    private List<HabitacionEntity> habitaciones = new ArrayList<>();

    public TipoHabitacionEntity() {
    }

    public TipoHabitacionEntity(Long id, String nombre, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
