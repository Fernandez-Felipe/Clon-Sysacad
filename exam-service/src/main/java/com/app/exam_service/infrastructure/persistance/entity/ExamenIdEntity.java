package com.app.exam_service.infrastructure.persistance.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExamenIdEntity {


    private Integer legajo;
    private Long materia_id;
    private Long id;

}
