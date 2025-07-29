package com.app.auth_service.infrastructure.persistance.mapper;

import com.app.auth_service.domain.model.Usuario;
import com.app.auth_service.infrastructure.persistance.adapter.DTOS.UserResponse;
import com.app.auth_service.infrastructure.persistance.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario mapToUsuario(UsuarioEntity entity){
        return Usuario.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .legajo(entity.getLegajo())
                .password(entity.getPassword())
                .build();
    }

    public UsuarioEntity mapToEntity(Usuario user){
        return UsuarioEntity.builder()
                .nombre(user.getNombre())
                .legajo(user.getLegajo())
                .password(user.getPassword())
                .build();
    }

    public UserResponse mapToResponse(Usuario user){

        return UserResponse.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .legajo(user.getLegajo())
                .build();

    }

}
