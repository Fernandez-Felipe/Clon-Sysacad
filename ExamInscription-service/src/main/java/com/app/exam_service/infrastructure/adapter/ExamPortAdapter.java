package com.app.exam_service.infrastructure.adapter;

import com.app.exam_service.domain.model.Examen;
import com.app.exam_service.domain.model.IdExamen;
import com.app.exam_service.domain.port.out.ExamRepositoryPort;
import com.app.exam_service.infrastructure.persistance.entity.ExamenEntity;
import com.app.exam_service.infrastructure.persistance.entity.ExamenIdEntity;
import com.app.exam_service.infrastructure.persistance.mapper.ExamMapper;
import com.app.exam_service.infrastructure.persistance.mapper.IdsMapper;
import com.app.exam_service.infrastructure.persistance.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExamPortAdapter implements ExamRepositoryPort {

    @Autowired
    ExamRepository repository;

    @Autowired
    ExamMapper Exammapper;

    @Autowired
    IdsMapper IdsMapper;

    @Override
    public Examen addExam(Examen examen) {

        ExamenEntity entity = Exammapper.domainToEntity(examen);
        repository.save(entity);

        return examen;

    }

    @Override
    public Examen getExam(IdExamen id) {

        ExamenIdEntity ids = IdsMapper.domainToEntity(id);

        ExamenEntity entity = repository.findById(ids).orElseThrow();

        return Exammapper.entityToModel(entity);

    }

    @Override
    public List<Examen> getAllExams(Integer legajo) {

        List<ExamenEntity> examenesEntity = repository.getAllExamnsByLegajo(legajo);
        List<Examen> examenes = new ArrayList<>();

        examenesEntity.forEach(examen -> Exammapper.entityToModel(examen));

        return examenes;
    }

    @Override
    public Examen UpdateExamen(Examen examen) {

        ExamenEntity entity = Exammapper.domainToEntity(examen);

        return Exammapper.entityToModel(repository.save(entity));
    }

    @Override
    public Examen DeleteExam(IdExamen id) {

        ExamenIdEntity entity = IdsMapper.domainToEntity(id);

        ExamenEntity deleted = repository.findById(entity).orElseThrow();

        repository.deleteById(entity);

        return Exammapper.entityToModel(deleted);

    }
}
