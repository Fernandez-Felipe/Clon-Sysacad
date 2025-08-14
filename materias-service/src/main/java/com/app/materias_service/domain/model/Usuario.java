package com.app.materias_service.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Usuario {

    private String nombre;
    private Integer legajo;
    private String rol;

}

