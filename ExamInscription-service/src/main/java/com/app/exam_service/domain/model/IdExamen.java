package com.app.exam_service.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IdExamen {

    private Integer legajo;
    private Long materia_id;
    private Long id;

}
