package com.app.auth_service.application.port.in;

import com.app.auth_service.infrastructure.adapter.Security.Dtos.UserLoginResponse;
import com.app.auth_service.infrastructure.adapter.out.DTOS.UserRequest;

public interface JwtServiceCaseUse {

    UserLoginResponse GenerarToken(UserRequest request);

}
