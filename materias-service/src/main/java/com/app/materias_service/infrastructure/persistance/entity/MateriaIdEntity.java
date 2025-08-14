package com.app.materias_service.infrastructure.persistance.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaIdEntity {

    private Long id;
    private Integer carreraid;

}

