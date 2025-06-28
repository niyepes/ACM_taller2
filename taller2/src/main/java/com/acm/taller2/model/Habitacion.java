package com.acm.taller2.model;

import lombok.Builder;

@Builder
public class Habitacion {
    private Long id;
    private Integer numeroHabitacion;
    private Integer precioDia;
    private Boolean disponible;
    private Long hotelID;
    private Long tipoHabitacionID;

    public Habitacion() {
    }

    public Habitacion(Long id, Integer numeroHabitacion, Integer precioDia, Boolean disponible, Long hotelID, Long tipoHabitacionID) {
        this.id = id;
        this.numeroHabitacion = numeroHabitacion;
        this.precioDia = precioDia;
        this.disponible = disponible;
        this.hotelID = hotelID;
        this.tipoHabitacionID = tipoHabitacionID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Integer getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(Integer precioDia) {
        this.precioDia = precioDia;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Long getHotelID() {
        return hotelID;
    }

    public void setHotelID(Long hotelID) {
        this.hotelID = hotelID;
    }

    public Long getTipoHabitacionID() {
        return tipoHabitacionID;
    }

    public void setTipoHabitacionID(Long tipoHabitacionID) {
        this.tipoHabitacionID = tipoHabitacionID;
    }


}
