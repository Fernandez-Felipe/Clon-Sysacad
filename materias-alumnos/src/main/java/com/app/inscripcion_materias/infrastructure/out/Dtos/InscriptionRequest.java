package com.app.inscripcion_materias.infrastructure.out.Dtos;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InscriptionRequest {

    private Integer Legajo;
    private Long materiaid;

}
