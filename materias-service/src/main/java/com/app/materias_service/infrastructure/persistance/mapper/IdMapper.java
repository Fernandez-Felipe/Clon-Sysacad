package com.app.materias_service.infrastructure.persistance.mapper;

import com.app.materias_service.domain.model.MateriaId;
import com.app.materias_service.infrastructure.persistance.entity.MateriaIdEntity;
import org.springframework.stereotype.Component;

@Component
public class IdMapper {

    public MateriaId entityToDomain(MateriaIdEntity entity){
        return MateriaId.builder()
                .id(entity.getId())
                .carreraid(entity.getCarreraid())
                .build();
    }

    public MateriaIdEntity domainToEntity(MateriaId id){
        return MateriaIdEntity.builder()
                .id(id.getId())
                .carreraid(id.getCarreraid())
                .build();
    }

}
