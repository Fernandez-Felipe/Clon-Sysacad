package com.app.auth_service.application.service;

import com.app.auth_service.domain.model.Usuario;
import com.app.auth_service.domain.port.in.UsuarioCaseUse;
import com.app.auth_service.domain.port.out.UsuarioRepositoryPort;
import com.app.auth_service.infrastructure.adapter.out.DTOS.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioService implements UsuarioCaseUse {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    @Override
    public UserResponse CrearUsuario(Usuario user) {
        return usuarioRepositoryPort.saveUsuario(user);
    }

    @Override
    public Usuario EncontrarUsuarioPorLaId(Long id) {
        return usuarioRepositoryPort.findById(id);
    }

    @Override
    public Usuario EncontrarUsuarioPorElLegajo(Integer legajo) {
        return usuarioRepositoryPort.findByLegajo(legajo);
    }

    @Override
    public UserResponse EliminarUsuarioPorLaId(Long id) {
        return usuarioRepositoryPort.deleteById(id);
    }

    @Override
    public UserResponse EliminarUsuarioPorElLegajo(Integer legajo) {
        return usuarioRepositoryPort.deleteByLegajo(legajo);
    }

    @Override
    public UserResponse ActualizarUsuarioPorLaId(Long id, Usuario user) {
        return usuarioRepositoryPort.updateUserById(id,user);
    }

    @Override
    public UserResponse ActualizarUsuarioPorElLegajo(Integer legajo, Usuario user) {
        return usuarioRepositoryPort.updateUserByLegajo(legajo,user);
    }
}
