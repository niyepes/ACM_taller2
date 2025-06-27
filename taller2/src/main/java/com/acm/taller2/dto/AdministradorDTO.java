package com.acm.taller2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public class AdministradorDTO {
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Long id;

    @Size(min = 1, max = 50, message = "El primer nombre debe tener de 1 a 50 caracteres")
    private String primerNombre;

    @Pattern(regexp = "^$|^.{1,50}$", message = "El segundo nombre debe tener entre 1 y 50 caracteres si se proporciona")
    private String segundoNombre;

    @Size(min = 1, max = 50, message = "El primer apellido debe tener de 1 a 50 caracteres")
    private String primerApellido;


    @Pattern(regexp = "^$|^.{1,50}$", message = "El segundo apellido debe tener entre 1 y 50 caracteres si se proporciona")
    private String segundoApellido;

    @Size(min = 1, max = 100, message = "El correo debe tener de 1 a 100 caracteres")
    @Email(message = "El correo no es válido")
    private String correo;

    @Size(min = 10, max = 10, message = "El telefono debe tener 10 digitos")
    private String telefono;

    public @Min(value = 1, message = "El id debe ser mayor a 0") Long getId() {
        return id;
    }

    public void setId(@Min(value = 1, message = "El id debe ser mayor a 0") Long id) {
        this.id = id;
    }

    public @Size(min = 1, max = 50, message = "El primer nombre debe tener de 1 a 50 caracteres") String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(@Size(min = 1, max = 50, message = "El primer nombre debe tener de 1 a 50 caracteres") String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public @Pattern(regexp = "^$|^.{1,50}$", message = "El segundo nombre debe tener entre 1 y 50 caracteres si se proporciona") String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(@Pattern(regexp = "^$|^.{1,50}$", message = "El segundo nombre debe tener entre 1 y 50 caracteres si se proporciona") String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public @Size(min = 1, max = 50, message = "El primer apellido debe tener de 1 a 50 caracteres") String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(@Size(min = 1, max = 50, message = "El primer apellido debe tener de 1 a 50 caracteres") String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public @Pattern(regexp = "^$|^.{1,50}$", message = "El segundo apellido debe tener entre 1 y 50 caracteres si se proporciona") String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(@Pattern(regexp = "^$|^.{1,50}$", message = "El segundo apellido debe tener entre 1 y 50 caracteres si se proporciona") String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public @Size(min = 1, max = 100, message = "El correo debe tener de 1 a 100 caracteres") @Email(message = "El correo no es válido") String getCorreo() {
        return correo;
    }

    public void setCorreo(@Size(min = 1, max = 100, message = "El correo debe tener de 1 a 100 caracteres") @Email(message = "El correo no es válido") String correo) {
        this.correo = correo;
    }

    public @Size(min = 10, max = 10, message = "El telefono debe tener 10 digitos") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@Size(min = 10, max = 10, message = "El telefono debe tener 10 digitos") String telefono) {
        this.telefono = telefono;
    }
}
