package com.acm.taller2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAuthDTO {
    private String nombreUsuario;
    private String contrasena;
}
