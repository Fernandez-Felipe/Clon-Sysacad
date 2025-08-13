package com.app.inscripcion_materias.infrastructure.out.Dtos;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InscriptionRequest {

    private Long materiaid;

}
