package com.app.auth_service.application.port.out;

import com.app.auth_service.infrastructure.out.persistance.DTOS.UserRequest;

public interface JwtServicePort {

    String GenerateToken(UserRequest request);
}
