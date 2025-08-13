package com.app.exam_service.infrastructure.persistance.mapper;

import com.app.exam_service.domain.model.Examen;
import com.app.exam_service.infrastructure.persistance.entity.ExamenEntity;
import com.app.exam_service.infrastructure.persistance.entity.ExamenIdEntity;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper {

    public Examen entityToModel(ExamenEntity entity){

        return Examen.builder()
                .id(entity.getId().getId())
                .legajo(entity.getId().getLegajo())
                .materia_id(entity.getId().getMateria_id())
                .estado(entity.getEstado())
                .build();
    }

    public ExamenEntity domainToEntity(Examen examen){

        ExamenIdEntity ids = ExamenIdEntity.builder()
                .legajo(examen.getLegajo())
                .materia_id(examen.getMateria_id())
                .id(examen.getId())
                .build();

        return ExamenEntity.builder()
                .id(ids)
                .estado(examen.getEstado())
                .build();

    }

}
