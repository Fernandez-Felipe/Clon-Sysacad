package com.app.auth_service.domain.port.out;

import com.app.auth_service.infrastructure.adapter.in.DTOS.UserRequest;

public interface JwtServicePort {

    String GenerateToken(UserRequest request);
}
