package com.app.carreras_service.infrastructure.adapter;

import com.app.carreras_service.domain.model.Carrera;
import com.app.carreras_service.domain.port.out.CarrerasRepositoryPort;
import com.app.carreras_service.infrastructure.persistance.entity.CarreraEntity;
import com.app.carreras_service.infrastructure.persistance.mapper.CarreraMapper;
import com.app.carreras_service.infrastructure.persistance.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarreraRepositoryAdapter implements CarrerasRepositoryPort {

    @Autowired
    CarreraRepository repository;

    @Autowired
    CarreraMapper mapper;

    @Override
    public Carrera addCarrera(Carrera carrera) {

        repository.save(mapper.domainToEntity(carrera));

        return carrera;
    }

    @Override
    public Carrera getCarrea(Long id) {

        CarreraEntity entity = repository.findById(id).orElseThrow();

        return mapper.entityToDomain(entity);
    }

    @Override
    public List<Carrera> getAllCarreras() {

        List<CarreraEntity> entities = repository.findAll();
        List<Carrera> carreras = new ArrayList<>();

        entities.forEach(entity -> carreras.add(mapper.entityToDomain(entity)));

        return carreras;
    }

    @Override
    public Carrera updateCarrera(Carrera carrera) {

        repository.save(mapper.domainToEntity(carrera));

        return carrera;
    }

    @Override
    public Carrera deleteCarrera(Long id) {

        CarreraEntity deletedEntity = repository.findById(id).orElseThrow();
        repository.deleteById(id);

        return mapper.entityToDomain(deletedEntity);
    }
}
