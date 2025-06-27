package com.acm.taller2.persistence;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "habitacion")
public class Habitacion implements Serializable {

    @Id
    @Column(name = "id_habitacion")
    private Long id;

    @Column(name = "numero_habitacion")
    private Long numeroHabitacion;

    @Column(name = "precio_dia")
    private Long precioDia;

    private boolean disponible;

    @ManyToOne
    @JoinColumn(name ="fk_id_hotel")
    private HotelEntity hotelEntity;

    @OneToOne
    @JoinColumn(name = "fk_id_tipo_habitacion")
    private TipoHabitacionEntity tipoHabitacion;
    public Habitacion() {
    }

    public Habitacion(Long id, Long numeroHabitacion, Long precioDia, boolean disponible) {
        this.id = id;
        this.numeroHabitacion = numeroHabitacion;
        this.precioDia = precioDia;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Long numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Long getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(Long precioDia) {
        this.precioDia = precioDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
