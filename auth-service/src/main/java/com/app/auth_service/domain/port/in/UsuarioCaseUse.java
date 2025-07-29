package com.app.auth_service.domain.port.in;

import com.app.auth_service.domain.model.Usuario;
import com.app.auth_service.infrastructure.persistance.adapter.DTOS.UserResponse;

public interface UsuarioCaseUse {

    UserResponse CrearUsuario(Usuario user);
    UserResponse EncontrarUsuarioPorLaId(Long id);
    UserResponse EncontrarUsuarioPorElLegajo(Integer legajo);
    UserResponse EliminarUsuarioPorLaId(Long id);
    UserResponse EliminarUsuarioPorElLegajo(Integer legajo);
    UserResponse ActualizarUsuarioPorLaId(Long id, Usuario user);
    UserResponse ActualizarUsuarioPorElLegajo(Integer legajo, Usuario user);

}
