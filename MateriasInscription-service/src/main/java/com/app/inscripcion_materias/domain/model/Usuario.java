package com.app.inscripcion_materias.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {

    private String name;
    private Integer legajo;
    private String role;

}
