package com.app.materias_service.infrastructure.persistance.mapper;

import com.app.materias_service.domain.model.Materia;
import com.app.materias_service.infrastructure.persistance.entity.MateriaEntity;
import com.app.materias_service.infrastructure.persistance.entity.MateriaIdEntity;
import org.springframework.stereotype.Component;

@Component
public class MateriaMapper {

    public Materia entityToDomain(MateriaEntity entity){

        return Materia.builder()
                .nombre(entity.getNombre())
                .id(entity.getId().getId())
                .carreraid(entity.getId().getCarreraid())
                .planDeEstudio(entity.getPlanDeEstudio())
                .build();
    }

    public MateriaEntity domainToEntity(Materia materia){

        MateriaIdEntity id = MateriaIdEntity.builder()
                .id(materia.getId())
                .carreraid(materia.getCarreraid())
                .build();

        return MateriaEntity.builder()
                .id(id)
                .nombre(materia.getNombre())
                .planDeEstudio(materia.getPlanDeEstudio())
                .build();
    }

}
