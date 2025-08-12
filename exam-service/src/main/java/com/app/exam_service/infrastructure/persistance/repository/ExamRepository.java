package com.app.exam_service.infrastructure.persistance.repository;

import com.app.exam_service.infrastructure.persistance.entity.ExamenEntity;
import com.app.exam_service.infrastructure.persistance.entity.ExamenIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamRepository extends JpaRepository<ExamenEntity, ExamenIdEntity> {

    @Query(value = "SELECT * examenes WHERE legajo = :legajo", nativeQuery = true)
    List<ExamenEntity> getAllExamnsByLegajo(@Param("legajo") Integer legajo);

}
