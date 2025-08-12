package com.app.exam_service.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Examen {

    private Long id;
    private Integer legajo;
    private Long materia_id;
    private String estado;

}
