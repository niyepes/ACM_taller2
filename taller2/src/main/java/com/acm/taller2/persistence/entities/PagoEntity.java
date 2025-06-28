package com.acm.taller2.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name="pago")
public class PagoEntity implements Serializable {
    @Id
    @Column(name = "id_pago")
    private Long id;
    private Timestamp fecha;

    @ManyToOne
    @JoinColumn(name = "fk_id_reserva")
    @JsonBackReference("reserva-pagos")
    private ReservaEntity  reserva;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "pago_total")
    private Integer pagoTotal;

    @OneToMany(mappedBy = "pago")
    @JsonManagedReference("pago-facturas")
    private List<FacturaEntity> facturas = new ArrayList<>();

    public PagoEntity() {
    }

    public PagoEntity(Long id, Timestamp fecha, String metodoPago, Integer pagoTotal) {
        this.id = id;
        this.fecha = fecha;
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

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }
}
