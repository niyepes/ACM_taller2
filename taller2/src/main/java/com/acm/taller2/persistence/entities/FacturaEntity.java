package com.acm.taller2.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Builder
@Table(name="factura")
public class FacturaEntity implements Serializable {
    @Id
    @Column(name = "id_factura")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_id_reserva")
    @JsonBackReference("reserva-facturas")
    private ReservaEntity reserva;

    @ManyToOne
    @JoinColumn(name = "fk_id_pago")
    @JsonBackReference("pago-facturas")
    private PagoEntity pago;

    @Column(name = "valor_total")
    private Integer valorTotal;

    @Column(name = "fecha_emision")
    private Timestamp fechaEmision;

    public FacturaEntity() {
    }

    public FacturaEntity(Long id, Integer valorTotal, Timestamp fechaEmision) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.fechaEmision = fechaEmision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
