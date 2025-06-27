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
@Table(name="reserva")
public class ReservaEntity implements Serializable {
    @Id
    @Column(name = "id_reserva")
    private Long id;
    @Column(name = "fecha_inicio")
    private Timestamp fechaInicio;
    @Column(name = "fecha_final")
    private Timestamp fechaFinal;
    @Column(name = "cantidad_dias")
    private Integer cantidadDias;
    private Boolean estado;
    @Column(name = "fecha_reserva")
    private Timestamp fechaReserva;

    @ManyToOne
    @JoinColumn(name="fk_id_habitacion")
    @JsonBackReference("habitacion-reservas")
    private HabitacionEntity habitacion;

    @ManyToOne
    @JoinColumn(name="fk_id_cliente")
    @JsonBackReference("cliente-reservas")
    private ClienteEntity  cliente;

    @OneToMany(mappedBy = "reserva")
    @JsonManagedReference("reserva-pagos")
    private List<PagoEntity> pagos = new ArrayList<>();

    @OneToMany(mappedBy = "reserva")
    @JsonManagedReference("reserva-facturas")
    private List<FacturaEntity> facturas = new ArrayList<>();

    public ReservaEntity() {
    }

    public ReservaEntity(Long id, Timestamp fechaInicio, Timestamp fechaFinal, Integer cantidadDias, Boolean estado, Timestamp fechaReserva) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.cantidadDias = cantidadDias;
        this.estado = estado;
        this.fechaReserva = fechaReserva;
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

    public Integer getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(Integer cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public Timestamp getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Timestamp fechaFinal) {
        this.fechaFinal = fechaFinal;
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
}
