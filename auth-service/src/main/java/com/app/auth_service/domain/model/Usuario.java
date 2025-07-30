package com.app.auth_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
public class Usuario {

    @Getter
    private Long id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private Integer legajo;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String rol;

}
