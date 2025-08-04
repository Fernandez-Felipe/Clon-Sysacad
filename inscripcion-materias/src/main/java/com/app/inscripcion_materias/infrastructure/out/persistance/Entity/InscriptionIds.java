package com.app.inscripcion_materias.infrastructure.out.persistance.Entity;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Builder
public class InscriptionIds {

    private Long materiaid;
    private Integer legajo;

}
