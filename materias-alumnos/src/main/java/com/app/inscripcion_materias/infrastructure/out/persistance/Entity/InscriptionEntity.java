package com.app.inscripcion_materias.infrastructure.out.persistance.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscriptionEntity {
    @EmbeddedId
    private InscriptionIds id;

    private String estado;

}
