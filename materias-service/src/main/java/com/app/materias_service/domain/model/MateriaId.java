package com.app.materias_service.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MateriaId {

    private Long id;
    private Integer carreraid;

}
