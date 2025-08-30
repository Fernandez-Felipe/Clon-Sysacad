package com.app.auth_service.domain.port.in;

import com.app.auth_service.infrastructure.adapter.in.DTOS.jwt.UserLoginResponse;
import com.app.auth_service.infrastructure.adapter.in.DTOS.UserRequest;

public interface JwtServiceCaseUse {

    UserLoginResponse GenerarToken(UserRequest request);

}
