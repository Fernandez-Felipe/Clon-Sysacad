package com.app.auth_service.infrastructure.persistance.adapter;

import com.app.auth_service.domain.model.Usuario;
import com.app.auth_service.domain.port.out.UsuarioRepositoryPort;
import com.app.auth_service.infrastructure.persistance.adapter.DTOS.UserResponse;
import com.app.auth_service.infrastructure.persistance.entity.UsuarioEntity;
import com.app.auth_service.infrastructure.persistance.mapper.UsuarioMapper;
import com.app.auth_service.infrastructure.persistance.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final UsuarioMapper mapper;

    @Override
    public UserResponse saveUsuario(Usuario user) {
        usuarioRepository.save(mapper.mapToEntity(user));
        return mapper.mapToResponse(user);
    }

    @Override
    public UserResponse findById(Long id) {

        UsuarioEntity user = usuarioRepository.findById(id).orElseThrow();

        return mapper.mapToResponse(mapper.mapToUsuario(user));
    }

    @Override
    public UserResponse findByLegajo(Integer legajo) {

        UsuarioEntity user = usuarioRepository.findByLegajo(legajo).orElseThrow();

        return mapper.mapToResponse(mapper.mapToUsuario(user));
    }

    @Override
    public UserResponse deleteById(Long id) {

        UsuarioEntity user = usuarioRepository.findById(id).orElseThrow();

        usuarioRepository.deleteById(id);

        return mapper.mapToResponse(mapper.mapToUsuario(user));
    }

    @Override
    public UserResponse deleteByLegajo(Integer legajo) {

        UsuarioEntity user = usuarioRepository.findByLegajo(legajo).orElseThrow();
        usuarioRepository.deleteByLegajo(legajo);

        return mapper.mapToResponse(mapper.mapToUsuario(user));
    }

    @Override
    public UserResponse updateUserById(Long id, Usuario user) {

        usuarioRepository.updateUsuarioById(user.getNombre(),user.getPassword(),id);

        UsuarioEntity updatedUser = usuarioRepository.findById(id).orElseThrow();

        return mapper.mapToResponse(mapper.mapToUsuario(updatedUser));
    }

    @Override
    public UserResponse updateUserByLegajo(Integer legajo, Usuario user) {

        usuarioRepository.updateUsuarioByLegajo(user.getNombre(),user.getPassword(),legajo);

        UsuarioEntity updatedUser = usuarioRepository.findByLegajo(legajo).orElseThrow();

        return mapper.mapToResponse(mapper.mapToUsuario(updatedUser));

    }
}
