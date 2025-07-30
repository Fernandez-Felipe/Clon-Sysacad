package com.app.auth_service.infrastructure.adapter;

import com.app.auth_service.domain.model.Usuario;
import com.app.auth_service.domain.port.out.UsuarioRepositoryPort;
import com.app.auth_service.infrastructure.adapter.out.DTOS.UserResponse;
import com.app.auth_service.infrastructure.adapter.out.persistance.entity.UsuarioEntity;
import com.app.auth_service.infrastructure.adapter.out.persistance.mapper.UsuarioMapper;
import com.app.auth_service.infrastructure.adapter.out.persistance.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UsuarioMapper mapper;

    @Override
    public UserResponse saveUsuario(Usuario user) {

        UsuarioEntity newUser = mapper.mapToEntity(user);
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        usuarioRepository.save(newUser);

        //medio tosco, hay que modificar el mapper para transformar una entity a un response
        return mapper.mapToResponse(mapper.mapToUsuario(newUser));
    }

    @Override
    public Usuario findById(Long id) {

        UsuarioEntity user = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado"));

        return mapper.mapToUsuario(user);
    }

    @Override
    public Usuario findByLegajo(Integer legajo) {

        UsuarioEntity user = usuarioRepository.findByLegajo(legajo).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado"));

        return mapper.mapToUsuario(user);
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

        usuarioRepository.updateUsuarioById(user.getNombre(),passwordEncoder.encode(user.getPassword()),id);

        UsuarioEntity updatedUser = usuarioRepository.findById(id).orElseThrow();

        return mapper.mapToResponse(mapper.mapToUsuario(updatedUser));
    }

    @Override
    public UserResponse updateUserByLegajo(Integer legajo, Usuario user) {

        usuarioRepository.updateUsuarioByLegajo(user.getNombre(),passwordEncoder.encode(user.getPassword()),legajo);

        UsuarioEntity updatedUser = usuarioRepository.findByLegajo(legajo).orElseThrow();

        return mapper.mapToResponse(mapper.mapToUsuario(updatedUser));

    }
}
