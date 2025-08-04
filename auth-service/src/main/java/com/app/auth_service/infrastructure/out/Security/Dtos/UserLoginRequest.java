package com.app.auth_service.infrastructure.out.Security.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLoginRequest {

    private Integer legajo;
    private String Password;

}
