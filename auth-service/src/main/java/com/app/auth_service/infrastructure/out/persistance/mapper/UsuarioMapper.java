package com.app.auth_service.infrastructure.out.persistance.mapper;

import com.app.auth_service.domain.model.Usuario;
import com.app.auth_service.infrastructure.out.persistance.DTOS.UserResponse;
import com.app.auth_service.infrastructure.out.persistance.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario mapToUsuario(UsuarioEntity entity){
        return Usuario.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .legajo(entity.getLegajo())
                .password(entity.getPassword())
                .rol(entity.getRol())
                .build();
    }

    public UsuarioEntity mapToEntity(Usuario user){
        return UsuarioEntity.builder()
                .nombre(user.getNombre())
                .legajo(user.getLegajo())
                .password(user.getPassword())
                .rol(user.getRol())
                .build();
    }

    public UserResponse mapToResponse(Usuario user){

        return UserResponse.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .legajo(user.getLegajo())
                .rol(user.getRol())
                .build();

    }

}
