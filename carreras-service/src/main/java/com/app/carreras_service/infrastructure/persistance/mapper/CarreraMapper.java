package com.app.carreras_service.infrastructure.persistance.mapper;

import com.app.carreras_service.domain.model.Carrera;
import com.app.carreras_service.infrastructure.persistance.entity.CarreraEntity;
import org.springframework.stereotype.Component;

@Component
public class CarreraMapper {

    public CarreraEntity domainToEntity(Carrera carrera){

        return CarreraEntity.builder()
                .name(carrera.getName())
                .description(carrera.getDescription())
                .build();

    }

    public Carrera entityToDomain(CarreraEntity entity){

        return Carrera.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();

    }

}
