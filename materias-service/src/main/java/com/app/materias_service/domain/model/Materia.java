package com.app.materias_service.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Materia {

    private Long id;
    private Integer carreraid;

    private String nombre;
    private String planDeEstudio;

}
