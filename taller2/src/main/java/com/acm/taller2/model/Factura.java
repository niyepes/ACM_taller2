package com.acm.taller2.model;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public class Factura {
    private Long id;
    private Long reservaID;
    private Long pagoID;
    private Integer valorTotal;
    private Timestamp fechaEmision;

    public Factura() {
    }

    public Factura(Long id, Long reservaID, Long pagoID, Integer valorTotal, Timestamp fechaEmision) {
        this.id = id;
        this.reservaID = reservaID;
        this.pagoID = pagoID;
        this.valorTotal = valorTotal;
        this.fechaEmision = fechaEmision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservaID() {
        return reservaID;
    }

    public void setReservaID(Long reservaID) {
        this.reservaID = reservaID;
    }

    public Long getPagoID() {
        return pagoID;
    }

    public void setPagoID(Long pagoID) {
        this.pagoID = pagoID;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Timestamp getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Timestamp fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}


