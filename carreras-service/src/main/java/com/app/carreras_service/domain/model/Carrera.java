package com.app.carreras_service.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Carrera {

    private Long id;
    private String name;
    private String description;

}
