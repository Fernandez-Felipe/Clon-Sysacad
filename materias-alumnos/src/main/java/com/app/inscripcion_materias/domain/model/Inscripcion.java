package com.app.inscripcion_materias.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Inscripcion {

    private Long materiaid;
    private Integer legajo;

    private String estado;

}
