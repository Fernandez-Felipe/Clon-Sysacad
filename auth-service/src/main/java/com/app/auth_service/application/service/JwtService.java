package com.app.auth_service.application.service;

import com.app.auth_service.application.port.in.JwtServiceCaseUse;
import com.app.auth_service.application.port.out.JwtServicePort;
import com.app.auth_service.infrastructure.adapter.Security.Dtos.UserLoginResponse;
import com.app.auth_service.infrastructure.adapter.out.DTOS.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JwtService implements JwtServiceCaseUse {

    private final JwtServicePort jwtServicePort;

    @Override
    public UserLoginResponse GenerarToken(UserRequest request) {
        return UserLoginResponse.builder()
                .token(jwtServicePort.GenerateToken(request))
                .build();
    }

}
