package com.app.materias_service.infrastructure.adapter;

import com.app.materias_service.domain.model.Materia;
import com.app.materias_service.domain.model.MateriaId;
import com.app.materias_service.domain.port.out.MateriaRepositoryPort;
import com.app.materias_service.infrastructure.persistance.entity.MateriaEntity;
import com.app.materias_service.infrastructure.persistance.entity.MateriaIdEntity;
import com.app.materias_service.infrastructure.persistance.mapper.IdMapper;
import com.app.materias_service.infrastructure.persistance.mapper.MateriaMapper;
import com.app.materias_service.infrastructure.persistance.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MateriaRepositoryAdapter implements MateriaRepositoryPort {

    @Autowired
    MateriaRepository repository;

    @Autowired
    MateriaMapper materiaMapper;

    @Autowired
    IdMapper idMapper;

    @Override
    public Materia addMateria(Materia materia) {
        MateriaEntity entity = materiaMapper.domainToEntity(materia);

        return materiaMapper.entityToDomain(repository.save(entity));

    }

    @Override
    public Materia getMateria(MateriaId id) {

        MateriaIdEntity idEntity = idMapper.domainToEntity(id);

        MateriaEntity entity = repository.findById(idEntity).orElseThrow();

        return materiaMapper.entityToDomain(entity);
    }

    @Override
    public List<Materia> getAllMaterias(Integer carrera_id) {

        List<MateriaEntity> entities = repository.findAllById_Carreraid(carrera_id);
        List<Materia> materias = new ArrayList<>();

        entities.forEach(entity -> materias.add(materiaMapper.entityToDomain(entity)));

        return materias;
    }

    @Override
    public Materia deleteMateria(MateriaId id) {

        MateriaIdEntity idEntity = idMapper.domainToEntity(id);
        MateriaEntity deletedEntity = repository.findById(idEntity).orElseThrow();

        repository.deleteById(idEntity);

        return materiaMapper.entityToDomain(deletedEntity);
    }

    @Override
    public Materia updateMateria(Materia materia) {

        MateriaEntity entity = materiaMapper.domainToEntity(materia);

        return materiaMapper.entityToDomain(repository.save(entity));
    }
}
