package com.app.inscripcion_materias.infrastructure.adapter;

import com.app.inscripcion_materias.domain.model.Inscripcion;
import com.app.inscripcion_materias.domain.port.out.InscriptionRepositoryPort;
import com.app.inscripcion_materias.infrastructure.out.persistance.Entity.InscriptionEntity;
import com.app.inscripcion_materias.infrastructure.out.persistance.Entity.InscriptionIds;
import com.app.inscripcion_materias.infrastructure.out.persistance.Mapper.InscriptionMapper;
import com.app.inscripcion_materias.infrastructure.out.persistance.Repository.InscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class InscriptionAdapter implements InscriptionRepositoryPort {

    private final InscriptionRepository inscriptionRepository;
    private final InscriptionMapper mapper;

    @Override
    public Inscripcion RealizeInscription(Inscripcion ids) {

        InscriptionIds NewInscription = InscriptionIds.builder()
                .materiaid(ids.getMateriaid()).
                legajo(ids.getLegajo()).
                build();

        return mapper.mapToInscripcion(
                inscriptionRepository.save(InscriptionEntity.builder()
                .id(NewInscription)
                .estado(ids.getEstado()).build())
        );
    }

    @Override
    public List<Inscripcion> CheckInscriptions(Integer legajo) {
        List<InscriptionEntity> entities = inscriptionRepository.findAllById_Legajo(legajo);
        List<Inscripcion> inscripciones = new ArrayList<>();

        entities.forEach(ins -> inscripciones.add(mapper.mapToInscripcion(ins)));

        return inscripciones;

    }

    @Override
    public Inscripcion DeleteInscription(InscriptionIds ids) {

        InscriptionEntity inscription = inscriptionRepository.findById(ids).orElseThrow();

        inscriptionRepository.deleteById(ids);

        return mapper.mapToInscripcion(inscription);

    }

    @Override
    public Inscripcion getOneInscription(InscriptionIds ids) {

        InscriptionEntity entity = inscriptionRepository.findById(ids).orElseThrow();

        return mapper.mapToInscripcion(entity);

    }
}
