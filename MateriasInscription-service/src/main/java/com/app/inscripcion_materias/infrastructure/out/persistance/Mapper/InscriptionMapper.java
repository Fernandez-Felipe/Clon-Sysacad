package com.app.inscripcion_materias.infrastructure.out.persistance.Mapper;

import com.app.inscripcion_materias.domain.model.Inscripcion;
import com.app.inscripcion_materias.infrastructure.out.persistance.Entity.InscriptionEntity;
import com.app.inscripcion_materias.infrastructure.out.persistance.Entity.InscriptionIds;
import org.springframework.stereotype.Component;

@Component
public class InscriptionMapper {

    public InscriptionEntity mapToEntity(Inscripcion inscripcion){
        InscriptionIds ids = InscriptionIds.builder()
                .materiaid(inscripcion.getMateriaid())
                .legajo(inscripcion.getLegajo())
                .build();

        return InscriptionEntity.builder()
                .id(ids)
                .estado(inscripcion.getEstado())
                .build();
    }

    public Inscripcion mapToInscripcion(InscriptionEntity entity){

        return Inscripcion.builder()
                .materiaid(entity.getId().getMateriaid())
                .legajo(entity.getId().getLegajo())
                .estado(entity.getEstado())
                .build();
    }

}
