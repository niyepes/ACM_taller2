package com.acm.taller2.model;

import lombok.Builder;

@Builder
public class TipoHabitacion {
    private Long id;
    private String nombre;
    private Integer cantidad;
    private Long hotelID;

    public TipoHabitacion() {
    }

    public TipoHabitacion(Long id, String nombre, Integer cantidad, Long hotelID) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.hotelID = hotelID;
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

    public Long getHotelID() {
        return hotelID;
    }

    public void setHotelID(Long hotelID) {
        this.hotelID = hotelID;
    }
}