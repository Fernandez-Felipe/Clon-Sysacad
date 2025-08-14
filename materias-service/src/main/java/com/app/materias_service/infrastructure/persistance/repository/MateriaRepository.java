package com.app.materias_service.infrastructure.persistance.repository;

import com.app.materias_service.infrastructure.persistance.entity.MateriaEntity;
import com.app.materias_service.infrastructure.persistance.entity.MateriaIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MateriaRepository extends JpaRepository<MateriaEntity, MateriaIdEntity> {

    List<MateriaEntity> findAllById_Carreraid(Integer Carreraid);

}
