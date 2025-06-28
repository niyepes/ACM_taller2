package com.acm.taller2.model;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public class Pago {
    private Long id;
    private Timestamp fecha;
    private Long reservaID;
    private String metodoPago;
    private Integer pagoTotal;

    public Pago() {
    }

    public Pago(Long id, Timestamp fecha, Long reservaID, String metodoPago, Integer pagoTotal) {
        this.id = id;
        this.fecha = fecha;
        this.reservaID = reservaID;
        this.metodoPago = metodoPago;
        this.pagoTotal = pagoTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Long getReservaID() {
        return reservaID;
    }

    public void setReservaID(Long reservaID) {
        this.reservaID = reservaID;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Integer getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(Integer pagoTotal) {
        this.pagoTotal = pagoTotal;
    }
}


