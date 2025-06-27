package com.acm.taller2.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name="habitacion")
public class HabitacionEntity implements Serializable {
    @Id
    @Column(name="id_habitacion")
    private Long id;
    @Column(name="numero_habitacion")
    private Integer numeroHabitacion;
    @Column(name="precio_dia")
    private Integer precioDia;
    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name="fk_id_hotel")
    @JsonBackReference("hotel-habitaciones")
    private HotelEntity hotel;

    @ManyToOne
    @JoinColumn(name="fk_id_tipo_habitacion")
    @JsonBackReference("tipoHabitacion-habitaciones")
    private TipoHabitacionEntity tipoHabitacion;

    @OneToMany(mappedBy = "habitacion")
    @JsonManagedReference("habitacion-reservas")
    private List<ReservaEntity> reservas =  new ArrayList<>();

    public HabitacionEntity() {
    }

    public HabitacionEntity(Long id, Integer numeroHabitacion, Integer precioDia, Boolean disponible) {
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


}
