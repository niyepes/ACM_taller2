package com.acm.taller2.dto;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HabitacionDTO {
    @Min(value = 1, message = "El id debe ser mayor que a 0")
    private Long id;

    @Min(value = 1, message = "El numero de habitacion debe ser mayor que 0")
    private Integer numeroHabitacion;

    @Min(value = 1, message = "El precio por día debe ser mayor a 0")
    private Integer precioDia;

    private Boolean disponible;

    private Long idhotel;

    private Long idTipoHabitacion;

    public @Min(value = 1, message = "El id debe ser mayor que a 0") Long getId() {
        return id;
    }

    public void setId(@Min(value = 1, message = "El id debe ser mayor que a 0") Long id) {
        this.id = id;
    }

    public @Min(value = 1, message = "El numero de habitacion debe ser mayor que 0") Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(@Min(value = 1, message = "El numero de habitacion debe ser mayor que 0") Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public @Min(value = 1, message = "El precio por día debe ser mayor a 0") Integer getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(@Min(value = 1, message = "El precio por día debe ser mayor a 0") Integer precioDia) {
        this.precioDia = precioDia;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Long getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(Long idhotel) {
        this.idhotel = idhotel;
    }

    public Long getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(Long idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }
}
