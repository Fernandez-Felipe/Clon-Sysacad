package com.app.auth_service.application.port.in;

import com.app.auth_service.infrastructure.out.Security.Dtos.UserLoginResponse;
import com.app.auth_service.infrastructure.out.persistance.DTOS.UserRequest;

public interface JwtServiceCaseUse {

    UserLoginResponse GenerarToken(UserRequest request);

}
