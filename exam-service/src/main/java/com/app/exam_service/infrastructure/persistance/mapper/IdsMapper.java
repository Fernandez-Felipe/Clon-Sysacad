package com.app.exam_service.infrastructure.persistance.mapper;

import com.app.exam_service.domain.model.IdExamen;
import com.app.exam_service.infrastructure.persistance.entity.ExamenIdEntity;
import org.springframework.stereotype.Component;

@Component
public class IdsMapper {

    public ExamenIdEntity domainToEntity(IdExamen ids){
        return ExamenIdEntity.builder()
                .legajo(ids.getLegajo())
                .materia_id(ids.getMateria_id())
                .id(ids.getId())
                .build();
    }

    public IdExamen entityToDomain(ExamenIdEntity entity){
        return IdExamen.builder().
                legajo(entity.getLegajo())
                .materia_id(entity.getMateria_id())
                .id(entity.getId())
                .build();
    }

}
