package com.app.auth_service.infrastructure.out.Security.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
public class UserLoginResponse {

    @Getter
    private final String token;

}
