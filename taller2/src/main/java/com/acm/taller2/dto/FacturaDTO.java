package com.acm.taller2.dto;

import jakarta.validation.constraints.Min;
import lombok.Builder;

import java.sql.Timestamp;

@Builder
public class FacturaDTO {
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Long id;

    private Long idreserva;

    private Long idpago;

    private Integer valorTotal;

    private Timestamp fechaEmision;

    public @Min(value = 1, message = "El id debe ser mayor a 0") Long getId() {
        return id;
    }

    public void setId(@Min(value = 1, message = "El id debe ser mayor a 0") Long id) {
        this.id = id;
    }

    public Long getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Long idreserva) {
        this.idreserva = idreserva;
    }

    public Long getIdpago() {
        return idpago;
    }

    public void setIdpago(Long idpago) {
        this.idpago = idpago;
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
