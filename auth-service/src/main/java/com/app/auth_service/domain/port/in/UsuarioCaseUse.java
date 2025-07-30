package com.app.auth_service.domain.port.in;

import com.app.auth_service.domain.model.Usuario;
import com.app.auth_service.infrastructure.adapter.out.DTOS.UserResponse;

public interface UsuarioCaseUse {

    UserResponse CrearUsuario(Usuario user);
    Usuario EncontrarUsuarioPorLaId(Long id);
    Usuario EncontrarUsuarioPorElLegajo(Integer legajo);
    UserResponse EliminarUsuarioPorLaId(Long id);
    UserResponse EliminarUsuarioPorElLegajo(Integer legajo);
    UserResponse ActualizarUsuarioPorLaId(Long id, Usuario user);
    UserResponse ActualizarUsuarioPorElLegajo(Integer legajo, Usuario user);

}
