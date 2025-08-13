package com.app.inscripcion_materias.infrastructure.out.persistance.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscriptionIds {

    private Long materiaid;
    private Integer legajo;

}
