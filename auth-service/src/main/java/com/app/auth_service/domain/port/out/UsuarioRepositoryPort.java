package com.app.auth_service.domain.port.out;

import com.app.auth_service.domain.model.Usuario;
import com.app.auth_service.infrastructure.persistance.adapter.DTOS.UserResponse;

public interface UsuarioRepositoryPort {

    UserResponse saveUsuario(Usuario user);
    UserResponse findById(Long id);
    UserResponse findByLegajo(Integer legajo);
    UserResponse deleteById(Long id);
    UserResponse deleteByLegajo(Integer Legajo);
    UserResponse updateUserById(Long id, Usuario user);
    UserResponse updateUserByLegajo(Integer legajo, Usuario user);

}
