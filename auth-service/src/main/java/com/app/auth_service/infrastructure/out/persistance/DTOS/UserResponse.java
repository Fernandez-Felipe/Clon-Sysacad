package com.app.auth_service.infrastructure.out.persistance.DTOS;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserResponse {

    private Long id;
    private Integer legajo;
    private String nombre;
    private String rol;

}
