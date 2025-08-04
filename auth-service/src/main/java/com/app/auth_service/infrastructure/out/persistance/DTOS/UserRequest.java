package com.app.auth_service.infrastructure.out.persistance.DTOS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserRequest {

    private String nombre;
    private Integer legajo;
    private String rol;

}
