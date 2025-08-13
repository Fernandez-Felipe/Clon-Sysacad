package com.app.exam_service.infrastructure.persistance.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IdExamenRequest {

    private Long materiaid;
    private Long id;

}
