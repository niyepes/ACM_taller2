package com.acm.taller2.model;

import lombok.Builder;

import java.sql.Timestamp;


@Builder
public class Reserva {
    private Long id;
    private Timestamp fechaInicio;
    private Timestamp fechaFinal;
    private Integer cantidadDias;
    private Boolean estado;
    private Timestamp fechaReserva;
    private Long habitacionID;
    private Long clienteID;

    public Reserva() {
    }

    public Reserva(Long id, Timestamp fechaInicio, Timestamp fechaFinal, Integer cantidadDias, Boolean estado, Timestamp fechaReserva, Long habitacionID, Long clienteID) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.cantidadDias = cantidadDias;
        this.estado = estado;
        this.fechaReserva = fechaReserva;
        this.habitacionID = habitacionID;
        this.clienteID = clienteID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Timestamp fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Integer getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(Integer cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Timestamp getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Timestamp fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Long getHabitacionID() {
        return habitacionID;
    }

    public void setHabitacionID(Long habitacionID) {
        this.habitacionID = habitacionID;
    }

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }
}
